package com.example.testdemo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

@JacksonXmlRootElement(localName = "DocDetails")
public class DocDetailsRes {

    @JacksonXmlProperty(localName = "IssuedTo")
    private IssuedTo issuedTo;

    @JacksonXmlProperty(localName = "URI")
    private String uri;

    @JacksonXmlProperty(localName = "DocContent")
    private byte[] docContent;

    @JacksonXmlProperty(localName = "DataContent")
    @JsonIgnore
    private String dataContent;

	public IssuedTo getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(IssuedTo issuedTo) {
		this.issuedTo = issuedTo;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public byte[] getDocContent() {
		return docContent;
	}

	public void setDocContent(byte[] docContent) {
		this.docContent = docContent;
	}

	public String getDataContent() {
		return dataContent;
	}

	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}
   
    
}
