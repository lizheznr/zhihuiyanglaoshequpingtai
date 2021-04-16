package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiehaodong
 * @Date: 2021/3/15 - 12:40
 * @Description: com.ruoyi.web.controller.system
 * @version: 1.0
 */
@RestController
@RequestMapping("/api_v1")
public class EmailController extends BaseController {
    @Autowired
    private JavaMailSender mailSender;
    @GetMapping("/send")
    private void send(){
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("1121051389@qq.com");
        // 收件人
        message.setTo("473817082@qq.com");
        // 邮件标题
        message.setSubject("Java测试邮件");
        // 邮件内容
        message.setText("你好，这是一条用于测试Spring Boot邮件发送功能的邮件！哈哈哈~~~");
        // 抄送人
        message.setCc("1121051389@qq.com");
        mailSender.send(message);
    }
}
