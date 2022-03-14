import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class SMSDemo {

    @Test
    public void test(){
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
        String to = "17635322744";
        String templateId= "1";
        String[] datas = {"2048","120"};
//        String subAppend="1234";  //可选 扩展码，四位数字 0~9999
//        String reqId="zt";  //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
        //HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
        HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }

    @Test
    public void test4(){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(8999) + 1000);
        }
    }

}
