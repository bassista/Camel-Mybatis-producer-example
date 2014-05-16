package com.example.proxy.impl;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.proxy.PersonProxy;
import com.example.proxy.entity.Person;


public class PersonProxyImpl implements PersonProxy{
	@Autowired
	private CamelContext camelContext;

	private ProducerTemplate producerTemplate;

	public List<Person> getPersonList() {
		producerTemplate = camelContext.createProducerTemplate();
		List<Person> personList = null;
		final Exchange exchange = producerTemplate.request(camelContext.getEndpoint("mybatis:selectPersons?statementType=SelectList"), new Processor() {
			
			public void process(Exchange arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
		if(!exchange.isFailed()){
			personList = (List<Person>) exchange.getOut().getBody();
		}
		return personList;
	}

	@Override
	public List<Person> filterPersonList(final String email) {

		producerTemplate = camelContext.createProducerTemplate();
		List<Person> personList = null;
		final Exchange exchange = producerTemplate.request(camelContext.getEndpoint("mybatis:getPerson?statementType=SelectList"), new Processor() {
			
			public void process(Exchange exch) throws Exception {
				exch.getIn().setBody(new Person(null, null, null, "someone@ymail.com"));
				
			}
		});
		if(!exchange.isFailed()){
			personList = (List<Person>) exchange.getOut().getBody();
		}
		return personList;
	
	}

}
