package com.bdqn.common;

import org.springframework.stereotype.Component;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件工具类
 */
@Component
public class MailUtil {

    public static String account = "z1574626814@126.com";            //替换为发件人账号
    public static String password = "UKBCOGGFZFEDDKBZ";              //替换为发件人账号密码

    /**
     * 邮件发送
     *
     * @param receiveMailAccount 收件人邮箱
     * @return 是否发送成功
     */
    public boolean sendMail(String receiveMailAccount, String code) {
        // 1. 使用Properties对象封装连接所需的信息
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议
        props.setProperty("mail.smtp.host", "smtp.126.com");    // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        // 2. 获取Session对象
        Session session = Session.getDefaultInstance(props);
        // 3. 封装Message对象
        MimeMessage message = null;
        try {
            message = createMimeMessage(session, account, receiveMailAccount, code);
            // 4. 使用Transport发送邮件
            Transport transport = session.getTransport();
            transport.connect(account, password);
            transport.sendMessage(message, message.getAllRecipients());
            // 5. 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String code) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "爱旅行", "UTF-8"));
        // 3. To: 收件人
        message.setRecipient(MimeMessage.RecipientType.TO,
                new InternetAddress(receiveMail, "XX用户", "UTF-8"));
        // 4. Subject: 邮件主题
        message.setSubject("爱旅行邮箱注册", "UTF-8");
        // 5. Content: 邮件正文
        message.setContent("验证码为:" + code + "，请在15分钟内进行账号激活", "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }
}
