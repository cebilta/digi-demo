package com.example.testdemo.model;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@JacksonXmlRootElement
@NoArgsConstructor
@Getter
@Setter

public class PullURIResponse {
	@JacksonXmlProperty(localName = "xmlns:ns2" , isAttribute = true)
	private final String namespace = "http://tempuri.org/";
	@JacksonXmlProperty(localName = "ResponseStatus")
	private ResponseStat responseStat; 
	@JacksonXmlProperty(localName = "DocDetails")
	private DocDetailsRes docDetails;
	public ResponseStat getResponseStat() {
		return responseStat;
	}
	public void setResponseStat(ResponseStat responseStat) {
		this.responseStat = responseStat;
	}
	public DocDetailsRes getDocDetails() {
		return docDetails;
	}
	public void setDocDetails(DocDetailsRes docDetails) {
		this.docDetails = docDetails;
	}
	public String getNamespace() {
		return namespace;
	}
}

