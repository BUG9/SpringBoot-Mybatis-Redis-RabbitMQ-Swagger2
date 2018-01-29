package com.springBoot.service;

import com.springBoot.model.User;

/**
 * Created by jingxian on 2018/1/29.
 */
public interface UserService {

    User findById(Long id);

}
