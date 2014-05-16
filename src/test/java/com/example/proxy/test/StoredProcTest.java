package com.example.proxy.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.proxy.PersonProxy;
import com.example.proxy.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/camelConfiguration-context.xml" })
public class StoredProcTest {

	@Autowired
	@Qualifier("personProxy")
	private PersonProxy personProxy;

	@Test
	public void getPersonList() {
		List<Person> personList = personProxy.getPersonList();
		Assert.assertNotNull(personList);
		Assert.assertFalse(personList.size() == 0);
	}

	@Test
	public void filterPersonList() {
		List<Person> personList = personProxy.filterPersonList("rajvaibhav.raj@gmail.com");
		Assert.assertNotNull(personList);
		Assert.assertFalse(personList.size() == 0);
	}

}
