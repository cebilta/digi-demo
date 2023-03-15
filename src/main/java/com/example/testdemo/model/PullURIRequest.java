package com.example.testdemo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor


@JacksonXmlRootElement(localName = "PullURIRequest")
public class PullURIRequest {

	@Override
	public String toString() {
		return "PullURIRequest [x=" + x + ", version=" + version + ", timestamp=" + timestamp + ", transactionId="
				+ transactionId + ", orgId=" + orgId + ", format=" + format + ", docDetails=" + docDetails + "]";
	}


	@JacksonXmlProperty(isAttribute = true, localName = "xmlns:ns2")
	public final String x = "http://helloworld.com/";
	
	@JacksonXmlProperty(isAttribute = true, localName = "ver")
    private String version;

    @JacksonXmlProperty(isAttribute = true, localName = "ts")
    private String timestamp;

    @JacksonXmlProperty(isAttribute = true, localName = "txn")
    private String transactionId;
    
	@JacksonXmlProperty(isAttribute = true, localName = "orgId")
    private String orgId;

    @JacksonXmlProperty(isAttribute = true, localName = "format")
    private String format;

    @JacksonXmlProperty(localName = "DocDetails")
    private DocDetails docDetails;

    public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getOrgId() {
		return orgId;
	}


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public DocDetails getDocDetails() {
		return docDetails;
	}


	public void setDocDetails(DocDetails docDetails) {
		this.docDetails = docDetails;
	}


    // constructors, getters and setters
}


