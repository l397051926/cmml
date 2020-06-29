
package com.lj.cmml.common.model;


import com.lj.cmml.common.enums.Status;

/**
 * result
 *
 * @param <T> T
 */
public class Result<T> {
    /**
     * status
     */
    private Integer statusCode;

    /**
     * message
     */
    private String message;

    /**
     * data
     */
    private T data;

    public Result(){}

    public Result(Integer statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
    public Result(Status status){
        this.statusCode = status.getCode();
        this.message = status.getMsg();
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Status{" +
                "code='" + statusCode + '\'' +
                ", msg='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
