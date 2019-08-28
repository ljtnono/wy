package cn.ljtnono.wyapp.aspect;

import cn.ljtnono.wyapp.pojo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller 异常拦截配置
 *
 * @author ljt
 * @version 1.1
 * @date 2019/8/28
 */
@ControllerAdvice(basePackages = {"cn.ljtnono.wyapp.controller"})
public class ExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    /**
     * 出现参数绑定缺少参数错误的时候，返回错误信息
     *
     * @param response 请求响应参数
     * @return JsonResult错误信息
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public JsonResult missingServletRequestParameterException(HttpServletResponse response) {
        return JsonResult.fail(response.getStatus(), "请求错误！缺少参数");
    }

    /**
     *  参数绑定出现参数类型错误，返回错误信息
     * @param response 请求响应参数
     * @return JsonResult错误信息
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public JsonResult methodArgumentTypeMismatchException(HttpServletResponse response) {
        return JsonResult.fail(response.getStatus(), "请求错误！参数类型错误");
    }

    /**
     * 其他异常处理方式
     *
     * @param response 请求响应参数
     * @return JsonResult 错误信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult globalException(HttpServletResponse response) {
        return JsonResult.fail(response.getStatus(), "请求错误");
    }

    /**
     * @param request  http请求
     * @param response http响应
     * @return JsonResut 对象
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public JsonResult requestMethodError(HttpServletRequest request, HttpServletResponse response) {
        return JsonResult.fail(response.getStatus(), "不允许" + request.getMethod() + "请求方式");
    }
}