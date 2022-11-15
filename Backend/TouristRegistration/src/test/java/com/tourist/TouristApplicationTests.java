package com.tourist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourist.entity.Tourist;
import com.tourist.repository.TouristRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TouristApplicationTests {

	@Autowired
	TouristRepository tRepo;
	
	@Test
	@Order(1)
	public void testCreate() {
		Tourist t= new Tourist();
		t.setAge(47);
		t.setFirstname("Madhu");
		t.setFromplace("Kerala");
		t.setGender("male");
		t.setId(121);
		t.setLastname("Sai");
		t.setNumberofdays(3);
		tRepo.save(t);
		assertNotNull(tRepo.findById(121).get());
	}
	
	@Test
	@Order(2)
	public void testDelete() {
		tRepo.deleteById(111);
		assertThat(tRepo.existsById(111)).isFalse();
	}
	
}
