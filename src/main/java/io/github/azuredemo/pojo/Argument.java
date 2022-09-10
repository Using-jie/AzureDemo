package io.github.azuredemo.pojo;


import feign.form.FormProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @author Luke
 * @Description
 * @Date 2022/9/6 19:50
 */
public class Argument {
    @Data
    public static class codeArgument implements Serializable {

        private String client_id;
        private String response_type;
        private String redirect_uri;
        private String scope;
      //  private String state;

    }

    @Data
    public static class tokenArgument implements Serializable {

        private String client_id;
        private String code;
        private String redirect_uri;
        private String client_secret;
        private String grant_type;


    }

    @Data
    public static class refreshArgument implements Serializable {
        private String client_id;
        private String grant_type;
        private String refresh_token;
        private String client_secret;
    }
}
