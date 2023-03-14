package com.example.testdemo;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.testdemo.model.DocDetails;
import com.example.testdemo.model.Employee;
import com.example.testdemo.model.PdfFile;
import com.example.testdemo.model.PullURIRequest;
import com.example.testdemo.repo.PdfFileRepo;
import com.example.testdemo.services.EmployeeService;

@RestController

public class HomeController {
	private Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EmployeeService empservice;
	private PdfFileRepo     pdfrepo;
	
	private String getURI() {
		return "URI";
	}
	
	private boolean isAccountExist() {
		return true;
	}
	
	@PostMapping(value = "/pull-uri")
	public PullURIRequest LoadHomePage(@RequestBody String pullreq) {
		System.out.println(pullreq);
		System.out.println(pullreq);
		
		Employee employee      = new Employee();
		DocDetails doc         = new DocDetails();
		PullURIRequest pullURI = new PullURIRequest();
		//System.out.println("PPO_number is given as " + pullreq.getDocDetails().getPpono());
		try {
		 byte[] pdfBytes = Files.readAllBytes(Paths.get("/home/nic/Documents/employee.pdf"));
		 employee.setPdf(pdfBytes);
		 employee.setPpo(232424L);
		 LocalDate today = LocalDate.of(2023, 5, 18);
		 employee.setDob( LocalDate.of(2023, 1, 1));
		 System.out.println(today);
		 empservice.saveEmployee(employee);
		}
		catch(IOException e){
			System.out.println("error occured" + e);
			return pullURI;
		}
		doc.setDigiLockerId("32434344");
		doc.setDob("23/234/324");
		doc.setDocType("2");
		doc.setFullName("hari");
		doc.setPhoto("2343dslfkdfjf");
		doc.setPpono(3242355L);
		doc.setUid("3434");
		doc.setUsrDob("324/04/324");
		pullURI.setDocDetails(doc);
		System.out.println("check date of birth is same" + empservice.isDOBMatches("01/01/2023", 232424L));
		return pullURI;
	}
	
	@PostMapping(value = "/addemp")
	public String addEmpDetails(@RequestBody Employee employee) {
		empservice.saveEmployee(employee);
		return "succeeded";
	}
	
	@GetMapping(value = "/hello")
	public String showHello() {
		log.info("hello function called");
		return "hello";
	}

	    @PostMapping("/upload-pdf")
	    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) {
	        try {
	            // Save the file to the server
	            String fileName = file.getOriginalFilename();
	            String filePath = "/home/nic/Projects/data" + fileName;
	            file.transferTo(new File(filePath));

	            // Save the file metadata to the database
	            PdfFile pdfFile = new PdfFile();
	            pdfFile.setFile_name(filePath);
	            pdfFile.setFile_path(filePath);
	            pdfrepo.save(pdfFile);

	            return new ResponseEntity<>("File uploaded successfully!", HttpStatus.OK);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>("Failed to upload file.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
