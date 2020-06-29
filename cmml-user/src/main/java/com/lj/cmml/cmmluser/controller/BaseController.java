
package com.lj.cmml.cmmluser.controller;

import com.lj.cmml.common.enums.Status;
import com.lj.cmml.common.model.Result;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.lj.cmml.common.Constants.*;


/**
 * base controller
 */
public class BaseController {


    /**
     * get ip address in the http request
     *
     * @param request http servlet request
     * @return client ip address
     */
    public static String getClientIpAddress(HttpServletRequest request) {
        String clientIp = request.getHeader(HTTP_X_FORWARDED_FOR);

        if (StringUtils.isNotEmpty(clientIp) && !StringUtils.equalsIgnoreCase(HTTP_HEADER_UNKNOWN, clientIp)) {
            int index = clientIp.indexOf(COMMA);
            if (index != -1) {
                return clientIp.substring(0, index);
            } else {
                return clientIp;
            }
        }

        clientIp = request.getHeader(HTTP_X_REAL_IP);
        if (StringUtils.isNotEmpty(clientIp) && !StringUtils.equalsIgnoreCase(HTTP_HEADER_UNKNOWN, clientIp)) {
            return clientIp;
        }

        return request.getRemoteAddr();
    }


    /**
     * success
     *
     * @return success result code
     */
    public Result success() {
        Result result = new Result();
        result.setStatusCode(Status.SUCCESS.getCode());
        result.setMessage(Status.SUCCESS.getMsg());

        return result;
    }

    /**
     * success does not need to return data
     *
     * @param msg success message
     * @return success result code
     */
    public Result success(String msg) {
        Result result = new Result();
        result.setStatusCode(Status.SUCCESS.getCode());
        result.setMessage(msg);

        return result;
    }

    /**
     * return data no paging
     *
     * @param msg  success message
     * @param list data list
     * @return success result code
     */
    public Result success(String msg, Object list) {
        Result result = getResult(msg, list);
        return result;
    }


    /**
     * return data no paging
     *
     * @param list success
     * @return success result code
     */
    public Result success(Object list) {
        Result result = getResult(Status.SUCCESS.getMsg(), list);
        return result;
    }

    /**
     * return the data use Map format, for example, passing the value of key, value, passing a value
     * eg. "/user/add"  then return user name: zhangsan
     *
     * @param msg    message
     * @param object success object data
     * @return success result code
     */
    public Result success(String msg, Map<String, Object> object) {
        Result result = getResult(msg, object);
        return result;
    }

    /**
     * error handle
     *
     * @param code
     * @param msg
     * @return
     */
    public Result info(Integer code, String msg, Object data) {
        Result result = new Result();
        result.setStatusCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    /**
     * error handle
     *
     * @param code result code
     * @param msg  result message
     * @return error result code
     */
    public Result error(Integer code, String msg) {
        Result result = new Result();
        result.setStatusCode(code);
        result.setMessage(msg);
        return result;
    }

    /**
     * get result
     *
     * @param msg  message
     * @param list object list
     * @return result code
     */
    private Result getResult(String msg, Object list, Status status) {
        Result result = new Result();
        result.setStatusCode(status.getCode());
        result.setMessage(msg);

        result.setData(list);
        return result;
    }

    /**
     * get result
     *
     * @param msg  message
     * @param list object list
     * @return result code
     */
    private Result getResult(String msg, Object list) {
        Result result = new Result();
        result.setStatusCode(Status.SUCCESS.getCode());
        result.setMessage(msg);

        result.setData(list);
        return result;
    }

    /**
     * error handle
     *
     * @param status
     * @return
     */
    public Result error(Status status) {
        Result result = new Result();
        result.setStatusCode(status.getCode());
        result.setMessage(status.getMsg());
        return result;
    }

}