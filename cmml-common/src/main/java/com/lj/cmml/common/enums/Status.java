
package com.lj.cmml.common.enums;

import lombok.Getter;

/**
 *  status enum
 */
@Getter
public enum Status {
    /**
     * 状态码 操作集合
     */
    SUCCESS(200, "操作成功")
    ;

    private int code;
    private String msg;

    private Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
