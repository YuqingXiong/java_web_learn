package com.rainsun.springbootmybatiscrud;

import com.rainsun.springbootmybatiscrud.Mapper.EmpMapper;
import com.rainsun.springbootmybatiscrud.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EmpMapper empMapper;

	@Test
	public void deleteTest() {
//		System.out.println(empMapper.delete(17));
	}

	@Test
	public void insertEmpTest(){
		//创建员工对象
		Emp emp = new Emp();
		emp.setUsername("jack");
		emp.setName("汤姆");
		emp.setImage("1.jpg");
		emp.setGender((short)1);
		emp.setJob((short)1);
		emp.setEntrydate(LocalDate.of(2000,1,1));
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		emp.setDeptId(1);
		//调用添加方法
		empMapper.insertEmp(emp);
		System.out.println(emp.getId());
	}

	@Test
	public void updateEmpTest(){
		//要修改的员工信息
		Emp emp = new Emp();
		emp.setId(14);
		emp.setUsername("songdaxia");
		emp.setPassword(null);
		emp.setName("老宋");
		emp.setImage("2.jpg");
		emp.setGender((short)1);
		emp.setJob((short)2);
		emp.setEntrydate(LocalDate.of(2012,1,1));
		emp.setCreateTime(null);
		emp.setUpdateTime(LocalDateTime.now());
		emp.setDeptId(2);
		//调用方法，修改员工数据
		empMapper.updateEmp(emp);
	}

	@Test
	public void selectEmpTest(){
		System.out.println(empMapper.selectEmp(5));
	}

	@Test
	public void selectEmpListTest(){
//		System.out.println(empMapper.selectEmpList("张", (short) 1,
//				LocalDate.of(2010, 1, 1), LocalDate.of(2023, 1, 1)));
//		System.out.println(empMapper.selectEmpList("张", null, null, null));
		System.out.println(empMapper.selectEmpList(null, (short) 1, null, null));
	}

	@Test
	public void deleteEmpListTest(){
		empMapper.deleteEmpList(Arrays.asList(13, 14, 15));
	}

}
