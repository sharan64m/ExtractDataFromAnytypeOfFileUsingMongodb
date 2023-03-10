package pdfupload.raj.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.kernel.log.SystemOutCounter;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pdfupload.raj.model.Student;
import pdfupload.raj.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;

	public String upload(MultipartFile file) throws Exception{
		// TODO Auto-generated method stub
		
		Student s=new Student();
		s.setId(file.hashCode());
		s.setName(file.getOriginalFilename());
	    
		
		//for file store in local storagee
		File fileuploadtolocalstorage=new File("C:\\Users\\softsuave\\Downloads\\projectupload\\"+file.getOriginalFilename());
	    file.transferTo(fileuploadtolocalstorage);
	   
		
		//convert iinto text && upload in db
		File f=new File("C:\\Users\\softsuave\\Downloads\\demouploadpath\\"+file.getOriginalFilename());
		PDDocument document = PDDocument.load(f);
		PDFTextStripper pdfStripper = new PDFTextStripper();
	    String text = pdfStripper.getText(document);
	    System.out.println(text);
        s.setData(text);
	    document.close();
	    studentRepo.save(s);
		return "file upload successfully";
	}

	public List<String> searchname(String name) {
		// TODO Auto-generated method stub
		List<Student> st=new ArrayList<Student>();
		List<String> str=new ArrayList<String>();
		st=studentRepo.findByName(name);
		for(int i=0;i<st.size();i++)
		{
			// this str1 store the get the name of the file from api or user 
			String str1=st.get(i).getName();
			
			//add the path or string + new file name store in str ,str is string is array list which carry string 
			str.add("C:\\\\Users\\\\softsuave\\\\Downloads\\\\projectupload\\\\"+str1);
		}
		return str;
		
	}

	public String download(String input) throws IOException {
		File file = new File("C:\\Users\\softsuave\\Downloads\\projectupload\\"+input);
	    PDDocument document = PDDocument.load(file);
	    PDFTextStripper stripper = new PDFTextStripper();
	    String text = stripper.getText(document);
	    document.close();
		return text;
	    
	   
	}

	

	
	
	public String supload(MultipartFile file) throws Exception{
		// TODO Auto-generated method stub
		
		Student s=new Student();
		s.setId(file.hashCode());
		s.setName(file.getOriginalFilename());
	    
		
		//for file store in local storagee
		File fileuploadtolocalstorage=new File("C:\\Users\\softsuave\\Downloads\\projectupload\\"+file.getOriginalFilename());
	    file.transferTo(fileuploadtolocalstorage);
	   
		
		//convert iinto text && upload in db
		File f=new File("C:\\Users\\softsuave\\Downloads\\demouploadpath\\"+file.getOriginalFilename());
		
        Tesseract tesseract =new Tesseract();
		
		tesseract.setDatapath("C:\\Users\\softsuave\\Downloads\\Tess4J\\tessdata");	
		
		String text =tesseract.doOCR(new File("C:\\Users\\softsuave\\Downloads\\demouploadpath\\"+file.getOriginalFilename()));
		
		System.out.println(text);
		 s.setData(text);
	    studentRepo.save(s);
	   
		return "file upload successfully";
	}
	

	

	

	


	
	

}
