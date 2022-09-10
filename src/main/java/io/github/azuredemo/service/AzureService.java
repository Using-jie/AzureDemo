package io.github.azuredemo.service;

import io.github.azuredemo.util.RespondUtil;

import java.util.Map;

/**
 * @author Luke
 * @Description
 * @Date 2022/9/4 13:45
 */
public interface AzureService {

    /**
     * 获取 Token
     * @param code code参数
     * @return 返回Token数据
     */
    public Map<String,Object> getToken(String code, String client_id);

    public Map<String,Object>refreshToken(String client_id, String refresh_token);

}
