package pdfupload.raj.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import pdfupload.raj.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/uploadstd")
	public String upload(@RequestParam("file") MultipartFile file) throws Exception
	{
		return studentService.upload(file);
	}
 
	@PostMapping("/searchIndb")
	public List<String> search(@RequestParam("name") String name)
	{
		return studentService.searchname(name);
	}
 
	
	@PostMapping("/download")
	public String downnload(@RequestParam("name") String input) throws IOException 
	{
		return studentService.download(input);
		
	}
	
	
	
	@PostMapping("/Suploadstd")
	public String supload(@RequestParam("file") MultipartFile file)  throws Exception
	{
	
		return studentService.supload(file);
		
	}
	
	
	
	
	
	
	
   
	/*@PostMapping("/scanuploadstd")
	public String scanupload(@RequestParam("scanfile") MultipartFile scanfile) throws Exception
	{
		return studentService.scanupload(scanfile);
	}*/
	
	
	
}
