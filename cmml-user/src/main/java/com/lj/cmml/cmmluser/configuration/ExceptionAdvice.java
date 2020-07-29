package com.lj.cmml.cmmluser.configuration;


import com.lj.cmml.cmmluser.controller.BaseController;
import com.lj.cmml.cmmluser.expections.UserException;
import com.lj.cmml.common.model.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author: lmx
 * @create: 2020/7/29
 **/
@ResponseBody
@ControllerAdvice
@Log4j2
public class ExceptionAdvice extends BaseController {

    /**
     * // 监控所有的被@RestController注解的Controllers类
     * @ControllerAdvice(annotations = RestController.class)
     *
     * // 监控特定的包下的Controllers类
     * @ControllerAdvice("org.example.controllers")
     *
     * // 监控指定类的Controllers类
     * @ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
     */

    /***
     * 参数绑定异常
     * @date 2018/10/16
     * @param exception HttpMessageNotReadableException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserException.class)
    public Result messageNotReadable(UserException exception){
        UserException userException = (UserException)exception.getCause();
        log.error("参数不匹配"+exception);
        return error(exception.getCode(), exception.getMessage());
    }

    /***
     * 全局异常，如果没有匹配到上述准确的异常，都会到这里来处理
     * @date 2018/10/16
     * @param e 没有匹配到的全局异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Result all(Exception e) {
        //这里的log使用了“，”，这样能把异常的堆栈信息全部打印出来，更容易定位bug
        log.error("异常：", e);
        return error(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

}
