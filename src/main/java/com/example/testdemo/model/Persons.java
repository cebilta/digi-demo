package com.example.testdemo.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Getter
@Setter

@JacksonXmlRootElement(localName = "Persons")
public class Persons {

    @JacksonXmlProperty(localName = "Person")
    //private List<Person> personList;
    private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}



    // Constructors, getters and setters
}
