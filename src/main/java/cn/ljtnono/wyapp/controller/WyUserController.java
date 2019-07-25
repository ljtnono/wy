package cn.ljtnono.wyapp.controller;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.pojo.JsonResult;
import cn.ljtnono.wyapp.service.WyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户数据获取
 *  @author ljt
 *  @date 2019/5/28
 *  @version 1.0
*/
@RestController
public class WyUserController {

    @Autowired
    private WyUserService wyUserService;


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
     * 处理注册请求
     * @return
     */
    @GetMapping("/regist")
    @ResponseBody
    public JsonResult regist() {

        return null;
    }
}
