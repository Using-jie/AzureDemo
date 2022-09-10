package io.github.azuredemo.controll;

import io.github.azuredemo.mapper.FeiMapper;
import io.github.azuredemo.pojo.Argument;
import io.github.azuredemo.service.AzureService;
import io.github.azuredemo.util.RedisCache;
import io.github.azuredemo.util.RespondUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static java.rmi.server.LogStream.log;


/**
 * @author Luke
 * @Description
 * @Date 2022/9/4 13:46
 */

@RestController
@Slf4j
//@RequiredArgsConstructor
@RequestMapping("/api/OneDrive")
public class AzureController {

    // TODO
    // 将Token过期时间 设定为 其 参数中的  expires_in
    // Token获取会返回 state 用于验证请求与响应中的状态值是否一致
    @Autowired
    private RedisCache redisCache ;

    @Autowired
    private AzureService azureService;


    @GetMapping
    public RespondUtil gainCode(String code,String state) {
       Map<String, Object> codeCache = new HashMap<>();
        codeCache.put("code",code);
        codeCache.put("state",state);
        AzureController.log.info("code"+"!!!!");
        AzureController.log.info((String) codeCache.get("code"));
        redisCache.setCacheMap("code",codeCache);
        return new RespondUtil("200",codeCache);
    }
    @PostMapping("/token" )
    public void gainToken(String code,String clientId ) {
        azureService.getToken(code,clientId);
    }

    @PostMapping("/refreshToken")
    public void gainRefreshToken(String client_id, String refresh_token) {
      azureService.refreshToken(client_id,refresh_token);
    }




}
