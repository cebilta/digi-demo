package com.example.testdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testdemo.model.PdfFile;

@Repository
public interface PdfFileRepo extends JpaRepository<PdfFile, Long> {
}
