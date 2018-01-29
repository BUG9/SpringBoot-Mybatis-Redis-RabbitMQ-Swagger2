//package com.springBoot;
//
//import com.springBoot.model.User;
//import com.springBoot.repository.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
///**
// * Created by jingxian on 2018/1/22.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositoryTest {
//
//    @Resource
//    private UserRepository userRepository;
//
//
//    @Before
//    public void addUser(){
//        User user = new User();
//        user.setAge(21);
//        user.setName("李四");
//
//        userRepository.save(user);
//    }
//
//    @Test
//    public void findByNameTest(){
//        System.out.println(userRepository.findByName("李四").toString());
//        System.out.println("______________________________");
//        System.out.println(userRepository.findByName("李四").toString());
//    }
//
//    @Test
//    public void findByNameAndAgeTest(){
//        System.out.println(userRepository.findByNameAndAge("李四",21).toString());
//    }
//
//    @Test
//    public void findUserTest(){
//
//        System.out.println(userRepository.queryByUser("李四").toString());
//    }
//
//}
