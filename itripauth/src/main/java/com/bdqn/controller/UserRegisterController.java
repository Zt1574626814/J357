package com.bdqn.controller;

import com.bdqn.common.*;
import com.bdqn.entity.ItripUser;
import com.bdqn.entity.ItripUserVO;
import com.bdqn.mapper.ItripUserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class UserRegisterController {

    @Resource
    ItripUserMapper mapper;

    @Resource
    SentSMSUtil smsUtil;

    @Resource
    RedisUtil redisUtil;

    @Resource
    MailUtil mailUtil;

    /**
     * 手机激活账号
     * @param user 用户手机号
     * @param code 短信验证码
     * @return 是否激活成功
     */
    @PutMapping("/validatephone")
    public Dto validatePhone(String user, String code) {
        return activate(user, code);
    }

    /**
     *
     * @param user 邮箱
     * @param code 验证码
     * @return 是否激活成功
     */
    @PutMapping("/activate")
    public Dto activateByMail(String user, String code){
        return activate(user, code);
    }

    private Dto activate(String user, String code) {
        try {
            String str = redisUtil.getKey(user);
            if (code.equals(str)) {
                return mapper.updateActivatedByUserCode(user, 1) > 0 ?
                        DtoUtil.returnSuccess("激活成功") :
                        DtoUtil.returnFail("激活失败", "20004");
            } else {
                return DtoUtil.returnFail("验证码错误", "20005");
            }
        } catch (Exception e) {
            return DtoUtil.returnFail("激活失败", "20004");
        }
    }

    /**
     * 手机号注册用户
     * @param userVO 前台传来的用户对象
     * @return 是否注册成功
     */
    @PostMapping("/registerbyphone")
    public Dto registerByPhone(@RequestBody ItripUserVO userVO) {
        // 把前台的信息插入到数据库中
        ItripUser itripUser = new ItripUser();
        itripUser.setUserCode(userVO.getUserCode());
        itripUser.setUserName(userVO.getUserName());
        itripUser.setUserPassWord(userVO.getUserPassword());
        itripUser.setActivated(0);
        int line = mapper.insert(itripUser);
        String code = String.valueOf(new Random().nextInt(8999) + 1000);
        // 发送短信验证码
        boolean message = smsUtil.message(userVO.getUserCode(), code, 600);
        if (message && line > 0) {
            redisUtil.setKey(userVO.getUserCode(), code, 600);
            return DtoUtil.returnSuccess("注册成功!");
        }
        return DtoUtil.returnFail("注册失败", "100042");
    }

    @GetMapping("/ckusr")
    public Dto checkUser(String name) {
        ItripUser user = new ItripUser();
        user.setUserCode(name);
        long count = mapper.count(user);
        return count > 0 ? DtoUtil.returnFail("该邮箱已被注册", "20010") : DtoUtil.returnSuccess("未被注册");
    }

    @PostMapping("/doregister")
    public Dto doregister(@RequestBody ItripUserVO userVO) {
        int insert;
        ItripUser user = new ItripUser();
        user.setUserCode(userVO.getUserCode());
        user.setUserName(userVO.getUserName());
        user.setUserPassWord(userVO.getUserPassword());
        user.setActivated(0);
        insert = mapper.insert(user);
        String code = String.valueOf(new Random().nextInt(8999) + 1000);
        boolean isMail = mailUtil.sendMail(userVO.getUserCode(), code);
        System.out.println(isMail ? "邮件发送成功" : "邮件发送失败");
        redisUtil.setKey(userVO.getUserCode(), code, 900);
        return insert == 1 ? DtoUtil.returnSuccess("注册成功") : DtoUtil.returnFail("注册失败!", "20005");
    }


}
