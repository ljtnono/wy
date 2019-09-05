package cn.ljtnono.wyapp.controller;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.pojo.JsonResult;
import cn.ljtnono.wyapp.service.WyUserService;
import cn.ljtnono.wyapp.utils.StringUtil;
import cn.ljtnono.wyapp.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

/**
 * 用户数据获取
 *
 * @author ljt
 * @version 1.0
 * @date 2019/5/28
 */
@RestController
public class WyUserController {

    @Autowired
    private WyUserService wyUserService;

    private final static Logger logger = LoggerFactory.getLogger(WyUserController.class);

    /**
     * 根据id 获取用户数据
     *
     * @param id 要获取的用户id
     * @return JSON字符串
     */
    @GetMapping("/getUserById")
    public WyUser getUserById(@RequestParam(value = "id") final String id) {
        return wyUserService.getUserById(id);
    }

    /**
     * 根据name获取用户数据
     *
     * @param name 用户的名字
     * @return JSON字符串
     */
    @GetMapping("/getUserByName")
    public WyUser getUserByName(@RequestParam(value = "name") final String name) {
        return wyUserService.getUserByName(name);
    }


    /**
     * 处理手机注册请求
     *
     * @param loginName 用户名
     * @param password  用户设置的密码
     * @param request   http请求
     * @param response  http相应
     * @return 返回携带User对象的JsonResult对象
     */
    @PostMapping("/regist")
    public JsonResult regist(@RequestParam("loginName") final String loginName,
                             @RequestParam("password") final String password,
                             @RequestParam("tel") final String tel,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        JsonResult result;
        try {
            // TODO 检查reference头防止恶意请求
            WyUser wyUser = wyUserService.regist(loginName, password, tel);
            if (wyUser == null) {
                if (logger.isErrorEnabled()) {
                    logger.info("[" + request.getRemoteAddr() + "]" + "请求注册账号失败！数据库插入失败");
                }
                throw new IllegalArgumentException("注册失败");
            } else {
                result = JsonResult.newBuilder().message("注册成功")
                        .totalCount(null)
                        .status(response.getStatus())
                        .request("success")
                        .data(Collections.singletonList(wyUser))
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
     * 检查用户名是否重复
     *
     * @param loginName 需要检查的用户名
     * @return 重复返回true 不重复返回false loginName不符合格式也返回false
     */
    @GetMapping("/checkRepeat")
    public JsonResult checkRepeat(@RequestParam("loginName") final String loginName,
                                  HttpServletResponse response) {

        JsonResult result;
        if (!UserUtil.validateLoginName(loginName)) {
            result = JsonResult.successForMessage("请检查用户名的格式", response.getStatus());
            return result;
        }
        boolean b = wyUserService.checkRepeat(loginName);
        result = JsonResult.successForMessage(b ? "true" : "false", response.getStatus());
        return result;
    }

    /**
     * 用户登录
     *
     * @param response http响应对象
     * @param type     登陆的类型
     *                 type = 1，使用账号和密码登录
     *                 type = 2,  使用手机号和验证码登陆
     *                 type = 3,  使用qq登陆
     *                 type = 4,  使用微信登陆
     * @return 成功返回携带user对象, 失败返回携带错误信息的JsonResult对象, 用户不存在返回错误信息
     */
    @PostMapping("/login")
    public JsonResult login(@RequestParam("type") int type,
                            WyUser user,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        if (type == 1) {
            user = loginByLoginName(user.getLoginName(), user.getPassword());
        } else if (type == 2) {
            user = loginByTelNum(user.getTel(), user.getPassword());
        } else if (type == 3) {

        } else {

        }
        JsonResult result = JsonResult.successForMessage("登陆成功", response.getStatus());
        if (user == null) {
            result.setMessage("账号密码不匹配！请重新输入");
            return result;
        }
        result.setData(Collections.singletonList(user));
        // TODO 将用户信息存储在session中

        return result;
    }

    /**
     * 根据用户名和密码来登录
     *
     * @param loginName 登录的用户名
     * @param password  登录的密码
     * @return 成功返回登录的WyUser对象，失败返回null
     * @throws IllegalArgumentException 如果loginName 或者 password为空字符串，抛出此异常
     */
    private WyUser loginByLoginName(final String loginName, final String password) {
        if (StringUtil.isEmpty(loginName) || StringUtil.isEmpty(password)) {
            throw new IllegalArgumentException("用户名或者密码不能为空");
        }
        if (!UserUtil.validateLoginName(loginName)) {
            if (!UserUtil.validatePassword(password)) {
                throw new IllegalArgumentException("密码是6-18位字母和数字组合，包括.+*-_/特殊字符");
            }
            throw new IllegalArgumentException("用户名是4-10位字母数字组合");
        }
        return wyUserService.loginByLoginName(loginName, password);
    }

    /**
     * 根据手机号码登录
     *
     * @param telNum   登录用户绑定的手机号
     * @param password 登录用户的密码
     * @return 成功返回登录的WyUser对象，失败返回null
     */
    private WyUser loginByTelNum(final String telNum, final String password) {
        return null;
    }

    /**
     * 根据注册时手机账号来修改密码
     *
     * @param oldPsw 原来的密码
     * @param telNum 注册时候绑定的手机
     * @param newPsw 新的密码
     * @return 成功返回修改成功 失败返回修改失败
     */
    @GetMapping("/updatePassword")
    public JsonResult updatePassword(
            @RequestParam("oldPsw") final String oldPsw,
            @RequestParam("telNum") final String telNum,
            @RequestParam("newPsw") final String newPsw,
            HttpServletResponse response, HttpServletRequest request) {
        // TODO 待测试，需要用户具有修改密码的权限
        JsonResult result = JsonResult.successForMessage("修改成功", response.getStatus());
        boolean updateResult = false;
        if (StringUtil.isEmpty(oldPsw) || StringUtil.isEmpty(telNum) || StringUtil.isEmpty(newPsw)) {
            result.setMessage("参数不能为空");
            return result;
        }
        if (!UserUtil.validatePassword(oldPsw) || !UserUtil.validatePassword(newPsw)) {
            result.setMessage("密码是6-18位字母和数字组合，包括.+*-_/特殊字符");
            if (!StringUtil.validateTel(telNum)) {
                result.setMessage("手机格式不正确");
            }
            return result;
        }
        WyUser user = new WyUser();
        user.setTel(telNum);
        user.setPassword(oldPsw);
        try {
            updateResult = wyUserService.updatePassword(user, newPsw);
        } catch (IllegalArgumentException e) {
            if (logger.isInfoEnabled()) {
                logger.info("[" + request.getRemoteAddr() + "]" + "请求修改密码失败！原因：" + e.getMessage());
            }
            result.setMessage("修改失败！请检查参数后重试");
        }
        if (!updateResult) {
            result.setMessage("修改失败！请检查参数后重试");
        }
        return result;
    }
}
