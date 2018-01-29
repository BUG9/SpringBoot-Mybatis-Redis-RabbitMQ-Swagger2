package com.springBoot.model;


import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String realName;

    private String password;

    private Integer age;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
