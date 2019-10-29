package com.cjc.demo1.advice;


import com.alibaba.fastjson.JSONObject;
import com.cjc.demo1.response.Response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author futao
 * Created on 2018/9/22-20:24.
 * 返回Rest风格的数据
 */
@ControllerAdvice(basePackages = "com.cjc.demo1.controller")
public class RestResultWrapper implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Response result = new Response(body);
        return JSONObject.toJSON(result);
    }
}

