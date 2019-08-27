package cn.ljtnono.wyapp.aspect;

import cn.ljtnono.wyapp.pojo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  controller 异常拦截配置
 *  @author ljt
 *  @date 2019/5/28
 *  @version 1.0
*/
@ControllerAdvice(basePackages = {"cn.ljtnono.wyapp.controller"})
public class ExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);
    /**
     * 出现参数绑定错误的时候，返回错误信息
     * @param response 请求响应参数
     * @return JsonResult错误信息
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public JsonResult missingServletRequestParameterException(HttpServletResponse response) {
        return JsonResult.newBuilder()
                .status(response.getStatus())
                .message("请求错误，请检查参数！")
                .request("fail")
                .totalCount(0)
                .data(null)
                .build();
    }
    /**
     *
     * @param response 请求响应参数
     * @return JsonResult 错误信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult globalException(HttpServletResponse response) {
        return JsonResult.newBuilder()
                .status(response.getStatus())
                .message("请求错误")
                .request("fail")
                .totalCount(0)
                .data(null)
                .build();
    }
    /**
     *
     * @param request http请求
     * @param response http响应
     * @return JsonResut 对象
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public JsonResult requestMethodError(HttpServletRequest request, HttpServletResponse response) {
        return JsonResult.newBuilder()
                .status(response.getStatus())
                .message("不允许" + request.getMethod() + "请求方式")
                .request("fail")
                .totalCount(0)
                .data(null)
                .build();
    }
}