package com.example.testdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pdf_files")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PdfFile {
    @Id
    @Column(name = "id")
    private Long ppo_number;
    private String file_name;
    public Long getPpo_number() {
		return ppo_number;
	}
	public void setPpo_number(Long ppo_number) {
		this.ppo_number = ppo_number;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	private String file_path;
}
