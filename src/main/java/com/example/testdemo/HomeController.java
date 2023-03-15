package com.example.testdemo;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.StringJoiner;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.util.ArrayList;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.testdemo.model.DocDetails;
import com.example.testdemo.model.DocDetailsRes;
import com.example.testdemo.model.Employee;
import com.example.testdemo.model.IssuedTo;
import com.example.testdemo.model.PdfFile;
import com.example.testdemo.model.Person;
import com.example.testdemo.model.Persons;
import com.example.testdemo.model.Photo;
import com.example.testdemo.model.PullURIRequest;
import com.example.testdemo.model.PullURIResponse;
import com.example.testdemo.model.ResponseStat;
import com.example.testdemo.repo.PdfFileRepo;
import com.example.testdemo.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

@RestController

public class HomeController {
	private Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EmployeeService empservice;
	private PdfFileRepo     pdfrepo;
	
	private String generateURI(Long ppo_number) {
		ArrayList<String> uris = new ArrayList<String>();
		StringJoiner      sjuri = new StringJoiner("-");
		uris.add("issuer-id");
		uris.add("doc-type");
		uris.add(ppo_number.toString());
		
		return (sjuri.add(uris.get(0)).add(uris.get(1)).add(uris.get(2))).toString();
	}
	
	private PullURIResponse createURIResponse(Employee curremp) {
		PullURIResponse pull_uri    = new PullURIResponse();
		ResponseStat    res_stat    = new ResponseStat();
		DocDetailsRes   doc_details = new DocDetailsRes();
		IssuedTo        issue_to    = new IssuedTo();
		Persons         persons     = new Persons();
		Person          person      = new Person();
		Photo           photo       = new Photo();
		
		pull_uri.setDocDetails(doc_details);
		pull_uri.setResponseStat(res_stat);
		
		
		res_stat.setResStat(1);
		res_stat.setStatus(1);
		res_stat.setTimeStamp(new Timestamp(new Date().getTime()));
		res_stat.setTransactionId(new Random().nextLong(10000));
		
		doc_details.setDocContent(Base64.getEncoder().encode(curremp.getPdf()));
		doc_details.setUri(generateURI(curremp.getPpo()));
		doc_details.setIssuedTo(issue_to);
		
		issue_to.setPersons(persons);
		
		persons.setPerson(person);
		
		person.setDob(curremp.getDob().toString());
		person.setGender(curremp.getGender());
		person.setName(curremp.getName());
		person.setPhone(curremp.getPhone());
		person.setPhoto(photo);
		
		photo.setContent("no photo available");
		photo.setFormat("jpeg");
		
		
		
		return pull_uri;
	}
	
	private boolean isAccountExist(Long ppo_number) {
		return true;
	}
	
	@PostMapping(value = "/pull-uri")
	public String LoadHomePage(@RequestBody String pullreq) throws JsonProcessingException {
		System.out.println(pullreq);
		XmlMapper xmlMapper = new XmlMapper();
		
		System.out.println(pullreq);
		
		Employee       employee   = new Employee();
		DocDetails     doc        = new DocDetails();
		PullURIRequest pullURI    = new PullURIRequest();
		String         pullResReq;
		//System.out.println("PPO_number is given as " + pullreq.getDocDetails().getPpono());
		try {
		 byte[] pdfBytes = Files.readAllBytes(Paths.get("/home/nic/Documents/employee.pdf"));
		 employee.setPdf(pdfBytes);
		 employee.setPpo(232424L);
		 LocalDate today = LocalDate.of(2023, 5, 18);
		 employee.setDob( LocalDate.of(2023, 1, 1));
		 employee.setGender("male");
		 employee.setName("anand");
		 employee.setPhone("8239284920");
		 System.out.println(today);
		 empservice.saveEmployee(employee);
		}
		catch(IOException e){
			System.out.println("error occured" + e);
			return "hello";
		}
		doc.setDigiLockerId("32434344");
		doc.setDob("23/234/324");
		doc.setDocType("2");
		doc.setFullName("hari");
		doc.setPhoto("2343dslfkdfjf");
		doc.setPpono(3242355L);
		doc.setUid(3243432L);
		doc.setUsrDob("324/04/324");
		pullURI.setDocDetails(doc);
		
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
		pullResReq = xmlMapper.writeValueAsString(pullURI);
		
		
		try {
			PullURIRequest pull_URI   = xmlMapper.readValue(pullreq, PullURIRequest.class);
			Long           ppo_number = pull_URI.getDocDetails().getPpono(); 
			if (isAccountExist(ppo_number)) {
				System.out.println("account exist for ppo");
				Employee curremp = empservice.findEmployeebyId(ppo_number);
				if (empservice.isDOBMatches(pull_URI.getDocDetails().getDob(),ppo_number)) {
					PullURIResponse pull_res = createURIResponse(curremp);
					String pull_result = xmlMapper.writeValueAsString(pull_res);
					return pull_result;
				}
				else {
					System.out.println("dob does not match");
					return pullResReq;
				}
			}
			else {
				System.out.println("acc number doesnt exist");
				return pullResReq;
			}
		}
		catch(JsonProcessingException e) {
			System.out.println("exeption occured " + e);
			return pullResReq;
		}
		
		//System.out.println("check date of birth is same" + empservice.isDOBMatches("01/01/2023", 232424L));
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
