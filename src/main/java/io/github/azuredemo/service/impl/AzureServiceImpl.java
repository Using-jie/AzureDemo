package io.github.azuredemo.service.impl;

import io.github.azuredemo.mapper.FeiMapper;
import io.github.azuredemo.pojo.Argument;
import io.github.azuredemo.service.AzureService;
import io.github.azuredemo.util.RedisCache;
import io.github.azuredemo.util.RespondUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Luke
 * @Description
 * @Date 2022/9/5 17:25
 */
@Service
@Slf4j
public class AzureServiceImpl implements AzureService {

    @Value("${redirect_uri}")
    private String redirect_uri;

    @Autowired
    private  FeiMapper feign;
    @Autowired
    private RedisCache redisCache ;

    @Override
    public Map<String, Object> getToken(String code, String clientId) {
        Map<String, Object> tokenCache = redisCache.getCacheMap("token");
        if (tokenCache != null) {
            return tokenCache;
        }
        Argument.tokenArgument tokenArgument = new Argument.tokenArgument();
        tokenArgument.setCode(code);
        tokenArgument.setClient_secret(FeiMapper.client_secret);
        tokenArgument.setGrant_type("authorization_code");
        tokenArgument.setClient_id(clientId);
        tokenArgument.setRedirect_uri(redirect_uri);
        tokenCache = feign.getToken(tokenArgument);
        log.info("Token gain Over");
        redisCache.setCacheMap("token",tokenCache);
        return tokenCache;
    }

    @Override
    public Map<String, Object> refreshToken(String client_id, String refresh_token) {
        Argument.refreshArgument refreshArgument = new Argument.refreshArgument();
        refreshArgument.setRefresh_token(refresh_token);
        refreshArgument.setClient_id(client_id);
        refreshArgument.setGrant_type("refresh_token");
        refreshArgument.setClient_secret(FeiMapper.client_secret);
        Map<String, Object> refreshTokenCache = feign.refreshToken(refreshArgument);
        log.info((String) refreshTokenCache.get("access_token"));
        redisCache.setCacheMap("refreshToken",refreshTokenCache);
        return refreshTokenCache;
    }
}
