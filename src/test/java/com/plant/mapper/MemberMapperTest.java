package com.plant.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plant.dto.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberMapperTest {

	private static final Logger log = LoggerFactory.getLogger("MemberMapperTest.class");
	
	@Autowired
	private PlantmemberMapper mm;
	
	@Test
	public void test() { //메소드 이름으로 객체가 만들어짐
		
		Plantmember m = mm.getById("rhdudwo");
		log.info("네임 찍어 :  " + m.getId());
		
	}

}
