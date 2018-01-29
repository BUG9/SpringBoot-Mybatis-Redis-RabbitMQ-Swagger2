package com.springBoot.mapper;

import com.springBoot.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * Created by jingxian on 2018/1/26.
 */
public interface UserMapper {

      @Insert("insert into users(real_name,password,age) values(#{realName},#{password},#{age})")
      void insert(User user);

      @Select("select * from users")
      @Results({
              @Result(property = "realName", column = "real_name"),
      })
      List<User> findAll();

      @Delete("delete from users where id = #{id}")
      void delete(Long id);


//      @Select("select * from users where id =#{id}")
//      @Results({
//              @Result(property = "realName", column = "real_name"),
//      })
      User findById(Long id);

//      @Update("UPDATE  users  SET  real_name = #{realName},password = #{password},age = #{age} where id = #{id}")
      void update(User user);
}
