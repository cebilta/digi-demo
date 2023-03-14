package com.example.testdemo.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	@Id
	@Column(name = "ppo_number")
	@NotNull(message = "ppo number should not be null")
	@Size(max=20, min = 1)
	private Long ppo;
	@Column(name =  "data_of_birth")
	private LocalDate dob;
	@Column(name = "ppo_pdf")
	@Lob
	private byte[] pdf;
	public Long getPpo() {
		return ppo;
	}
	public void setPpo(Long ppo) {
		this.ppo = ppo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
}
