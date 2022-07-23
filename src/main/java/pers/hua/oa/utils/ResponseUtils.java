package pers.hua.oa.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseUtils {
    private String code;
    private String message;
    private Map data = new LinkedHashMap<>();

    /**
     * 如果与数据库数据匹配 返回状态码0表示成功
     */
    public ResponseUtils(){
        this.code = "0";
        this.message = "success";
    }

    /**
     * 如果不匹配 传入异长参数
     * @param code 异常类型
     * @param message 异常消息
     */
    public ResponseUtils(String code , String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 匹配则返回用户信息
     * @param key 返回数据库参数名
     * @param value 参数值
     * @return 将put返回
     */
    public ResponseUtils put(String key , Object value){
        this.data.put(key, value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    /**
     * 利用ObjectMapper的setSerializationInclusion剔除空值，
     * 将当前参数保存为json
     * @return 返回json数据
     */
    public String toJsonString(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            String json = objectMapper.writeValueAsString(this);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
