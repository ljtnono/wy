package cn.ljtnono.wyapp.controller;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.pojo.JsonResult;
import cn.ljtnono.wyapp.service.WyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 *  用户数据获取
 *  @author ljt
 *  @date 2019/5/28
 *  @version 1.0
*/
@Controller
public class WyUserController {

    @Autowired
    private WyUserService wyUserService;

    private static Logger logger = LoggerFactory.getLogger(WyUserController.class);

    /**
     * 根据id 获取用户数据
     * @param id 要获取的用户id
     * @return JSON字符串
     */
    @GetMapping("/getUserById")
    @ResponseBody
    public WyUser getUserById(@RequestParam(value = "id") String id) {
        return wyUserService.getUserById(id);
    }

    /**
     * 根据name获取用户数据
     * @param name 用户的名字
     * @return JSON字符串
     */
    @GetMapping("/getUserByName")
    @ResponseBody
    public WyUser getUserByName(@RequestParam(value = "name") String name) {
        return wyUserService.getUserByName(name);
    }


    /**
     * 处理手机注册请求
     * @param loginName 用户名
     * @param password 用户设置的密码
     * @param request http请求
     * @param response http相应
     * @return 返回携带User对象的JsonResult对象
     */
    @PostMapping("/regist")
    @ResponseBody
    public JsonResult regist(@RequestParam("loginName") String loginName,
                             @RequestParam("password") String password,
                             @RequestParam("tel")String tel,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        JsonResult result;
        try {
            // TODO 检查reference头防止恶意请求
            WyUser wyUser = wyUserService.regist(loginName, password, tel);
            if (wyUser == null) {
                if (logger.isErrorEnabled()) {
                    logger.info("[" + request.getRemoteAddr() + "]" + "请求注册账号失败！数据库插入失败" );
                }
                throw new IllegalArgumentException("注册失败！");
            } else {
                result = JsonResult.newBuilder().message("注册成功！")
                        .totalCount(null)
                        .status(response.getStatus())
                        .request("success")
                        .data(Arrays.asList(wyUser))
                        .build();
            }
        } catch (IllegalArgumentException e) {
            if (logger.isInfoEnabled()) {
                logger.info("[" + request.getRemoteAddr() + "]" + "请求注册账号失败！原因：" + e.getMessage());
            }
            result = JsonResult.fail(response.getStatus(), e.getMessage());
        }
        return result;
    }
}
