package com.example.testdemo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class DocDetails {

    public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDigiLockerId() {
		return digiLockerId;
	}

	public void setDigiLockerId(String digiLockerId) {
		this.digiLockerId = digiLockerId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getPpono() {
		return ppono;
	}

	public void setPpono(Long ppono) {
		this.ppono = ppono;
	}

	public String getUsrDob() {
		return usrDob;
	}

	public void setUsrDob(String usrDob) {
		this.usrDob = usrDob;
	}

	@JacksonXmlProperty(localName = "DocType")
    private String docType;

    @JacksonXmlProperty(localName = "DigiLockerId")
    private String digiLockerId;

    @JacksonXmlProperty( localName = "UID")
    private String uid;

    @JacksonXmlProperty( localName = "FullName")
    private String fullName;

    @JacksonXmlProperty(localName = "DOB")
    private String dob;

    @JacksonXmlProperty( localName = "Photo")
    private String photo;

    @Override
	public String toString() {
		return "DocDetails [docType=" + docType + ", digiLockerId=" + digiLockerId + ", uid=" + uid + ", fullName="
				+ fullName + ", dob=" + dob + ", photo=" + photo + ", ppono=" + ppono + ", usrDob=" + usrDob + "]";
	}

	@JacksonXmlProperty(localName = "PPONO")
    private Long ppono;

    @JacksonXmlProperty(localName = "USRDOB")
    private String usrDob;

    // constructors, getters and setters
}