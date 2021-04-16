package com.ruoyi.web.controller.tool;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
  
  
public class HttpClientUtil {  
    private RequestConfig requestConfig = RequestConfig.custom()  
            .setSocketTimeout(15000)  
            .setConnectTimeout(15000)  
            .setConnectionRequestTimeout(15000)  
            .build();  
      
    private static HttpClientUtil instance = null;  
    private HttpClientUtil(){}  
    public static HttpClientUtil getInstance(){  
        if (instance == null) {  
            instance = new HttpClientUtil();  
        }  
        return instance;  
    }  
      
    /** 
     * 发送 post请求 
     * @param httpUrl 地址 
     */  
    public String sendHttpPost(String httpUrl) {  
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost    
        return sendHttpPost(httpPost,"utf-8");  
    }  
      
      
    /** 
     * 发送 post请求 
     * @param httpUrl 地址 
     * @param maps 参数 
     *  @param type 字符编码格式 
     */  
    public String sendHttpPost(String httpUrl, Map<String, String> maps,String type) {  
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost    
        // 创建参数队列    
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
        for (String key : maps.keySet()) {  
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));  
        }  
        try {  
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, type));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return sendHttpPost(httpPost,type);  
    }  
      
    /** 
     * 发送Post请求 
     * @param httpPost 
     * @return 
     */  
    private String sendHttpPost(HttpPost httpPost,String reponseType) {  
        CloseableHttpClient httpClient = null;  
        CloseableHttpResponse response = null;  
        HttpEntity entity = null;  
        String responseContent = null;  
        try {  
            // 创建默认的httpClient实例.  
            httpClient = HttpClients.createDefault();  
            httpPost.setConfig(requestConfig);  
            // 执行请求  
            response = httpClient.execute(httpPost);  
            entity = response.getEntity();  
            responseContent = EntityUtils.toString(entity, reponseType);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                // 关闭连接,释放资源  
                if (response != null) {  
                    response.close();  
                }  
                if (httpClient != null) {  
                    httpClient.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return responseContent;  
    }  
  
    /** 
     * 发送 get请求 
     * @param httpUrl 
     */  
    public String sendHttpGet(String httpUrl) {  
        HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求  
        return sendHttpGet(httpGet);  
    }  
      
    /** 
     * 发送 get请求Https 
     * @param httpUrl 
     */  
    public String sendHttpsGet(String httpUrl) {  
        HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求  
        return sendHttpsGet(httpGet);  
    }  
    
    /**
     * @Title: sendMsgUtf8
     * @Description: TODO(发送utf8)
     * @param: @param Uid
     * @param: @param Key
     * @param: @param content
     * @param: @param mobiles
     * @param: @return      
     * @date: 2017-3-22 下午5:58:07
     * @throws
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public int sendMsgUtf8(String Uid,String Key,String content,String mobiles){
    	Map maps = new HashMap();
		maps.put("Uid", Uid);
		maps.put("Key", Key);
		maps.put("smsMob", mobiles);
		maps.put("smsText", content);
		String result = sendHttpPost("http://utf8.sms.webchinese.cn", maps, "utf-8");
		return Integer.parseInt(result);
    }
    
    /**
     * @Title: sendMsgUtf8
     * @Description: TODO(发送utf8)
     * @param: @param Uid
     * @param: @param Key
     * @param: @param content
     * @param: @param mobiles
     * @param: @return     
     * @return: int     
     * @author:  ly
     * @date: 2017-3-22 下午5:58:07
     * @throws
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public int sendMsgGbk(String Uid,String Key,String content,String mobiles){
    	Map maps = new HashMap();
		maps.put("Uid", Uid);
		maps.put("Key", Key);
		maps.put("smsMob", mobiles);
		maps.put("smsText", content);
		String result = sendHttpPost("http://gbk.sms.webchinese.cn", maps, "gbk");
		return Integer.parseInt(result);
    }
      
    /** 
     * 发送Get请求 
     * @param httpPost 
     * @return 
     */  
    private String sendHttpGet(HttpGet httpGet) {  
        CloseableHttpClient httpClient = null;  
        CloseableHttpResponse response = null;  
        HttpEntity entity = null;  
        String responseContent = null;  
        try {  
            // 创建默认的httpClient实例.  
            httpClient = HttpClients.createDefault();  
            httpGet.setConfig(requestConfig);  
            // 执行请求  
            response = httpClient.execute(httpGet);  
            entity = response.getEntity();  
            responseContent = EntityUtils.toString(entity, "UTF-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                // 关闭连接,释放资源  
                if (response != null) {  
                    response.close();  
                }  
                if (httpClient != null) {  
                    httpClient.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return responseContent;  
    }  
      
    /** 
     * 发送Get请求Https 
     * @param httpPost 
     * @return 
     */  
    private String sendHttpsGet(HttpGet httpGet) {  
        CloseableHttpClient httpClient = null;  
        CloseableHttpResponse response = null;  
        HttpEntity entity = null;  
        String responseContent = null;  
        try {  
            // 创建默认的httpClient实例.  
            PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.load(new URL(httpGet.getURI().toString()));  
            DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);  
            httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();  
            httpGet.setConfig(requestConfig);  
            // 执行请求  
            response = httpClient.execute(httpGet);  
            entity = response.getEntity();  
            responseContent = EntityUtils.toString(entity, "UTF-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                // 关闭连接,释放资源  
                if (response != null) {  
                    response.close();  
                }  
                if (httpClient != null) {  
                    httpClient.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return responseContent;  
    }  
    
    /**
	 * @Title: getErrorMsg
	 * @Description: TODO(返回异常原因)
	 * @param: @param errorCode
	 */
	public String getErrorMsg(int errorCode){
		if(errorCode==-1){
			return "没有该用户账户";
		}else if(errorCode==-2){
			return "接口密钥不正确";
		}else if(errorCode==-3){
			return "短信数量不足";
		}else if(errorCode==-4){
			return "手机号格式不正确";
		}else if(errorCode==-21){
			return "MD5接口密钥加密不正确";
		}else if(errorCode==-11){
			return "该用户被禁用";
		}else if(errorCode==-14){
			return "短信内容出现非法字符";
		}else if(errorCode==-41){
			return "手机号码为空";
		}else if(errorCode==-42){
			return "短信内容为空";
		}else if(errorCode==-51){
			return "短信签名格式不正确";
		}else if(errorCode==-6){
			return "IP限制";
		}else{
			return "未知错误码:"+errorCode;
		}
	}
}  