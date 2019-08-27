package cn.ljtnono.wyapp.controller;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.pojo.JsonResult;
import cn.ljtnono.wyapp.service.WyUserService;
import cn.ljtnono.wyapp.utils.UserUtil;
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

    private final static Logger logger = LoggerFactory.getLogger(WyUserController.class);

    /**
     * 根据id 获取用户数据
     * @param id 要获取的用户id
     * @return JSON字符串
     */
    @GetMapping("/getUserById")
    @ResponseBody
    public WyUser getUserById(@RequestParam(value = "id") final String id) {
        return wyUserService.getUserById(id);
    }

    /**
     * 根据name获取用户数据
     * @param name 用户的名字
     * @return JSON字符串
     */
    @GetMapping("/getUserByName")
    @ResponseBody
    public WyUser getUserByName(@RequestParam(value = "name") final String name) {
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
    public JsonResult regist(@RequestParam("loginName") final String loginName,
                             @RequestParam("password") final String password,
                             @RequestParam("tel")final String tel,
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

    /**
     *  检查用户名是否重复
     * @param loginName 需要检查的用户名
     * @return 重复返回true 不重复返回false loginName不符合格式也返回false
     */
    @GetMapping("/checkRepeat")
    @ResponseBody
    public JsonResult checkRepeat(@RequestParam("loginName") final String loginName,
                                  HttpServletResponse response) {

        JsonResult result;
        if (!UserUtil.validateLoginName(loginName)) {
            result = JsonResult.successForMessage("请检查用户名的格式", response.getStatus());
        }
        boolean b = wyUserService.checkRepeat(loginName);
        result = JsonResult.successForMessage(b ? "true" : "false", response.getStatus());
        return result;
    }

    /**
     * 用户登录
     * @param response http响应对象
     * @return 成功返回携带user对象
     */
    @PostMapping("/login")
    @ResponseBody
    public JsonResult login(@RequestParam("type") int type,
                            HttpServletResponse response) {
        if (type == 1) {

        } else if (type == 2) {

        } else if (type == 3) {

        } else {

        }
        return null;
    }

    /**
     * 根据用户名和密码来登录
     * @param loginName 登录的用户名
     * @param password 登录的密码
     * @exception IllegalArgumentException 如果loginName 或者 password为空字符串，抛出此异常
     * @return 成功返回登录的WyUser对象，失败返回null
     */
    private WyUser loginByLoginName(final String loginName, final String password) {

        return null;
    }

    /**
     * 根据手机号码登录
     * @param telNum 登录用户绑定的手机号
     * @param password 登录用户的密码
     * @return 成功返回登录的WyUser对象，失败返回null
     */
    private WyUser loginByTelNum(final String telNum, final String password) {

        return null;
    }

}
