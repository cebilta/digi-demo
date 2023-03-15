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
@JacksonXmlRootElement(localName = "IssuedTo")
public class IssuedTo {

    @JacksonXmlProperty(localName = "Persons")
    private Persons persons;

	public Persons getPersons() {
		return persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

    // Constructors, getters and setters
}
