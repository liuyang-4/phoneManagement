package com.liuyang.phonemanagement.commons.exception.handle;

import com.liuyang.phonemanagement.commons.exception.exceptions.NoDataException;
import com.liuyang.phonemanagement.commons.exception.exceptions.NoLoginException;
import com.liuyang.phonemanagement.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MyExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    public ApiResult runtionExceptionHandle(RuntimeException e) {
        log.error("请求发生异常:{}", e.getMessage(), e);
        return ApiResult.sendResult(500, e.getMessage());
    }
    /**
     * 对自定义异常的统一处理
     *
     * @param e
     * @return
     * @annotation ExceptionHandler 参数异常类
     */
    @ExceptionHandler(NoDataException.class)
    public ApiResult noDataExceptionHandle(NoDataException e) {
        log.error(e.getMessage());
        return ApiResult.sendResult(400, "获取数据为空");
    }
    @ExceptionHandler(NoLoginException.class)
    public ApiResult noLoginExceptionHandle(NoLoginException e) {
        log.error(e.getMessage());
        return ApiResult.sendResult(202, "登录已失效");
    }
}
