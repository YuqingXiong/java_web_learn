package com.rainsun.springbootmybatisquickstart;

import com.rainsun.springbootmybatisquickstart.mapper.UserMapper;
import com.rainsun.springbootmybatisquickstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Consumer;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	public UserMapper userMapper;

	@Test
	public void testListUser(){
//		System.out.println(userMapper.list());
		userMapper.list().forEach(System.out::println);
	}

}
