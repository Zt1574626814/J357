package com.bdqn.controller;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.common.*;
import com.bdqn.entity.ItripUser;
import com.bdqn.mapper.ItripUserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@RestController
@RequestMapping("/api")
public class ItripController {

    @Resource
    ItripUserMapper mapper;

    @Resource
    TokenBiz tokenBiz;

    @Resource
    RedisUtil redisUtil;

    @RequestMapping("/dologin")
    public Dto doLogin(String name, String password, HttpServletRequest request) {
        ItripUser user = mapper.login(name, password);
        if (user != null) {
            // 模拟session的票据
            String token = tokenBiz.generateToken(request.getHeader("User-Agent"), user);
            // 把这个token存储到redis中
            // fastjson 把当前用户转为字符串
            redisUtil.setKey(token, JSONArray.toJSONString(user), 7200);
            ItripTokenVO obj = new ItripTokenVO(token, Calendar.getInstance().getTimeInMillis() * 3600 * 2, Calendar.getInstance().getTimeInMillis());
            return DtoUtil.returnDataSuccess(obj);
        }
        return DtoUtil.returnFail("登录失败", "1000");
    }

    @GetMapping("/logout")
    public Dto logout(@RequestHeader String token) {
        redisUtil.delKey(token);
        return DtoUtil.returnSuccess("注销成功");
    }

}

