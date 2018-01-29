package com.springBoot.controller;

import com.springBoot.mapper.UserMapper;
import com.springBoot.model.User;
import com.springBoot.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by jingxian on 2018/1/22.
 */
@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下
public class UserController {

        @Resource
        private UserMapper userMapper;

        @Resource
        private UserService userService;

        @ApiOperation(value = "获取用户列表",notes = "")
        @RequestMapping(value = "/findAll", method = RequestMethod.GET)
        public List<User> getUserList() {
            // 处理"/users/"的GET请求，用来获取用户列表
            // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
            List<User> r = userMapper.findAll();
            return r;
        }

        @ApiOperation(value = "创建用户",notes = "根据传过来的User数据创建用户" )
        @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User",paramType = "body")
        @RequestMapping(value = "/insert", method = RequestMethod.POST)
        public String postUser(@ModelAttribute //或者使用  @RequestBody
                                               User user) {
            // 处理"/users/"的POST请求，用来创建User
            // 除了@ModelAttribute绑定参数之外，还可以通过@RequestBody绑定参数
            userMapper.insert(user);
            return "success";
        }

        @ApiOperation(value = "根据Id获取用户信息",notes = "")
        @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType ="Long",paramType = "path")
        @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
        public User getUser(@PathVariable Long id) {
            // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
            // url中的id可通过@PathVariable绑定到函数的参数中
            return userService.findById(id);
        }

        @ApiOperation(value = "更新用户信息",notes = "根据id及User参数修改用户信息")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
                @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User",paramType = "body")
        })
        @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
        public String putUser(@PathVariable("id")Long id,@ModelAttribute User user) {
            // 处理"/users/{id}"的PUT请求，用来更新User信息
            userMapper.update(user);
            return "success";
        }

        @ApiOperation(value = "根据Id删除用户",notes = "")
        @ApiImplicitParam(name = "id",value = "用户ID",dataType = "Long",required = true, paramType = "path")
        @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
        public String deleteUser(@PathVariable Long id) {
            // 处理"/users/{id}"的DELETE请求，用来删除User
            userMapper.delete(id);
            return "success";
        }
}