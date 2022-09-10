package io.github.azuredemo.config;

import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import io.github.azuredemo.mapper.FeiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
// TODO 对于异常值 进行捕获处理
/**
 * @author Luke
 * @Description
 * @Date 2022/9/6 17:52
 */
@Configuration
@Import({FeignClientsConfiguration.class})
public class FeignConfig {

    private final Feign.Builder builder;

//    public FeignConfig(Feign.Builder builder) {
//        this.builder = builder;
//    }
    @Autowired
    public FeignConfig(
            Encoder encoder, Decoder decoder,
            Contract contract
    ) {
        this.builder = Feign.builder().encoder(encoder).decoder(decoder)
                .contract(contract);
    }
    @Bean
    public FeiMapper creatFeiMapper() {
        return builder.target(FeiMapper.class,FeiMapper.BASE_URL);
    }
}
