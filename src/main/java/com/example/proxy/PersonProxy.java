package com.example.proxy;

import java.util.List;

import com.example.proxy.entity.Person;

public interface PersonProxy {
	
	public List<Person> getPersonList();
	
	public List<Person> filterPersonList(final String email);

}
