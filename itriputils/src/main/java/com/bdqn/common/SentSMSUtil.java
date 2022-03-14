package com.bdqn.common;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class SentSMSUtil {

    public boolean message(String phone, String code, int second) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8a216da87f63aaf1017f6c29e8a70180";
        String accountToken = "aa5e679c848841e784df407ab6172caf";
        //请使用管理控制台中已创建应用的APPID
        String appId = "8a216da87f63aaf1017f6c4ac7ab0205";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String templateId = "1";
        String[] datas = {code, String.valueOf(second / 10)};
        HashMap<String, Object> result = sdk.sendTemplateSMS(phone, templateId, datas);
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
            return true;
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            return false;
        }
    }

}
