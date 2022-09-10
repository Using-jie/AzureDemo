package io.github.azuredemo.mapper;


import io.github.azuredemo.pojo.Argument;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author Luke
 * @Description Fei执行类
 * @Date 2022/9/6 16:56
 */
public interface FeiMapper {
    String BASE_URL = "https://login.microsoftonline.com";
    String client_secret = "-EA8Q~RiNRZ8CelOOGVryZSjo4Q2aCcqPfCdAbbF";


    @GetMapping(value = "/common/oauth2/v2.0/authorize")
    void getCode(@PathVariable Argument.codeArgument arg);

    @PostMapping(value = "/common/oauth2/v2.0/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Map<String,Object> getToken(Argument.tokenArgument arg);

    @PostMapping(value = "/common/oauth2/v2.0/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Map<String,Object> refreshToken(Argument.refreshArgument arg);

}
