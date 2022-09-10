package io.github.azuredemo.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author Luke
 * @Description
 * @Date 2022/9/5 17:07
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespondUtil implements Serializable {
    private final Object date;
    private final String code;

    public RespondUtil(String msg, Object date, String code) {
        this.date = date;
        this.code = code;
    }

    public RespondUtil(String code,Object date) {
        this.code = code;
        this.date = date;
    }

}
