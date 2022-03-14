package com.bdqn.controller;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.common.Dto;
import com.bdqn.common.DtoUtil;
import com.bdqn.common.RedisUtil;
import com.bdqn.entity.*;
import com.bdqn.mapper.ItripUserLinkUserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/api/userinfo"})
public class UserInfoController {
    @Resource
    ItripUserLinkUserMapper itripUserLinkUserMapper;

    @Resource
    RedisUtil redisUtil;

    @PostMapping("queryuserlinkuser")
    public Dto queryUserLinkUser(@RequestBody ItripSearchUserLinkUserVO itripSearchUserLinkUserVO, HttpServletRequest request) {
        String token = request.getHeader("token");
        ItripUser itripUser = (ItripUser)JSONArray.parseObject(redisUtil.getKey(token), ItripUser.class);
        // 写死
        if (null == itripUser) {
            return DtoUtil.returnFail("token失效，请重新登录", "100000");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", itripUser.getId());
            map.put("linkUserName", itripSearchUserLinkUserVO.getLinkUserName());

            try {
                List<ItripUserLinkUser> userLinkUserList = this.itripUserLinkUserMapper.getItripUserLinkUserListByMap(map);
                return DtoUtil.returnSuccess("获取常用联系人信息成功", userLinkUserList);
            } catch (Exception var7) {
                var7.printStackTrace();
                return DtoUtil.returnFail("获取常用联系人信息失败", "100401");
            }
        }
    }

    @PostMapping({"/adduserlinkuser"})
    public Dto addUserLinkUser(@RequestBody ItripAddUserLinkUserVO itripAddUserLinkUserVO, HttpServletRequest request) {
        String token = request.getHeader("token");
        ItripUser itripUser = (ItripUser)JSONArray.parseObject(redisUtil.getKey(token), ItripUser.class);
        if (itripAddUserLinkUserVO == null) {
            return DtoUtil.returnFail("不能提交空，请填写常用联系人信息", "100412");
        } else {
            if (null == itripUser) {
                return DtoUtil.returnFail("token失效，请重新登录", "100000");
            } else {
                itripAddUserLinkUserVO.setUserId(itripUser.getId());
                int insert = this.itripUserLinkUserMapper.insert(itripAddUserLinkUserVO);
                return insert > 0 ? DtoUtil.returnSuccess() : DtoUtil.returnFail("新增常用联系人失败", "100411");
            }
        }
    }

    @GetMapping({"/deluserlinkuser"})
    public Dto delUserLinkUser(Long[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        ItripUser itripUser = (ItripUser)JSONArray.parseObject(redisUtil.getKey(token), ItripUser.class);
        if (ids.length == 0) {
            return DtoUtil.returnFail("请选择要删除的常用联系人", "100433");
        } else {
            if (null != itripUser) {
                try {
                    this.itripUserLinkUserMapper.deleteByIds(ids);
                    return DtoUtil.returnSuccess("删除常用联系人成功");
                } catch (Exception var6) {
                    var6.printStackTrace();
                    return DtoUtil.returnFail("删除常用联系人失败", "100432");
                }
            } else {
                return DtoUtil.returnFail("token失效，请重新登录", "100000");
            }
        }
    }

    @PostMapping({"/modifyuserlinkuser"})
    public Dto updateUserLinkUser(@RequestBody ItripModifyUserLinkUserVO itripModifyUserLinkUserVO, HttpServletRequest request) {
        String token = request.getHeader("token");
        ItripUser itripUser = (ItripUser)JSONArray.parseObject(redisUtil.getKey(token), ItripUser.class);
        if (null != itripUser && null != itripModifyUserLinkUserVO) {
            ItripUserLinkUser itripUserLinkUser = new ItripUserLinkUser();
            itripUserLinkUser.setId(itripModifyUserLinkUserVO.getId());
            itripUserLinkUser.setLinkUserName(itripModifyUserLinkUserVO.getLinkUserName());
            itripUserLinkUser.setLinkIdCardType(itripModifyUserLinkUserVO.getLinkIdCardType());
            itripUserLinkUser.setLinkIdCard(itripModifyUserLinkUserVO.getLinkIdCard());
            itripUserLinkUser.setUserId(itripUser.getId());
            itripUserLinkUser.setLinkPhone(itripModifyUserLinkUserVO.getLinkPhone());
            itripUserLinkUser.setModifiedBy(itripUser.getId());
            try {
                this.itripUserLinkUserMapper.update(itripUserLinkUser);
            } catch (Exception var7) {
                var7.printStackTrace();
                return DtoUtil.returnFail("修改常用联系人失败", "100421");
            }
            return DtoUtil.returnSuccess("修改常用联系人成功");
        } else {
            return null != itripUser ? DtoUtil.returnFail("不能提交空，请填写常用联系人信息", "100422") : DtoUtil.returnFail("token失效，请重新登录", "100000");
        }
    }
}
