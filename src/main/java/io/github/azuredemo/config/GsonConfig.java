package io.github.azuredemo.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Luke
 * @Description
 * @Date 2022/9/7 12:16
 */
@Configuration
public class GsonConfig {
    @Bean
    public HttpMessageConverters customConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();

        messageConverters.add(new GsonHttpMessageConverter(GsonConfig.GSON));

        return new HttpMessageConverters(true, messageConverters);
    }

    private static final Gson GSON = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .disableInnerClassSerialization()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
}
