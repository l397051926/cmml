package com.lj.cmml.cmmluser.expections;

import lombok.Getter;

/**
 * @author: lmx
 * @create: 2020/7/29
 **/
@Getter
public class UserException extends RuntimeException {

    private Integer code;
    private String message;

    public UserException(Integer code, String message){
        super();
        this.message = message;
        this.code = code;
    }

}
