package com.ruoyi.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Oldman;
import com.ruoyi.system.mapper.OldmanMapper;
import com.ruoyi.system.service.IOldmanService;
import com.ruoyi.web.controller.tool.HttpClientUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;


/**
 * @Author: xiehaodong
 * @Date: 2021/3/9 - 13:29
 * @Description: com.ruoyi.web.controller.system
 * @version: 1.0
 */
@RestController
@RequestMapping("/api_v1")
public class ApiController extends BaseController {
    private static AjaxResult ajaxResult = null;
    private String prefix = "api_v1";

    @Autowired
    IOldmanService oldmanService;
    @Autowired
    OldmanMapper oldmanMapper;
    @Autowired
    Oldman oldman;


    /*发送短信内容**/
    //用户名
    private static String Uid = "lizheznr";
    //接口安全秘钥
    private static String Key = "d41d8cd98f00b204e980";
    //手机号码，多个号码如13800000000,13800000001,13800000002
    private static String smsMob = "15823841432";
    //短信内容
    private static String smsText;





    @ApiOperation(value = "用户注册",httpMethod = "GET")
    @GetMapping("/register")
    @ResponseBody
    public void save(HttpServletRequest request, HttpServletResponse response,
                      Oldman oldman) throws IOException {
        setRequest(request,response);
        System.out.println(oldman.toString());
        // 获取微信小程序get的参数值并打印
        int row =oldmanService.insertOldman(oldman);
        if(row>1){
            System.out.println("数据插入成功");
        }
        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write("接口测试成功，后端返回小程序");
        out.flush();
    }

    @ApiOperation(value = "用户信息查询",httpMethod = "GET")
    @GetMapping("/getUserInfo")
    @ResponseBody
    public Object queryUserInfo (HttpServletRequest request, HttpServletResponse response) throws IOException{
        setRequest(request,response);
        Oldman oldman=oldmanService.queryUser();
        JSONObject jsonObject=new JSONObject();
        //JSONObject jsonObject= JSON.parseObject(json);
        jsonObject.put("oldman",oldman);
        return jsonObject;
    }

    public void setRequest(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
    }
    /*发送短信**/
    @RequestMapping("/sendSMS")
    @ResponseBody
    public void sendMsg(String text,String array){
        HttpClientUtil client = HttpClientUtil.getInstance();
        //UTF发送
        smsText="您有新的订单，请及时处理，位置："+text+",资费详情："+array+"。";
        System.out.println("信息1----------------------------->"+smsText);
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }


    /*发送短信**/
    @RequestMapping("/sendSMS2")
    @ResponseBody
    public void sendMsg2(){
        HttpClientUtil client = HttpClientUtil.getInstance();
        //UTF发送
        smsText="摄像头检测到异常，请立即前往查看";
        System.out.println("信息1----------------------------->"+smsText);
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }
}
