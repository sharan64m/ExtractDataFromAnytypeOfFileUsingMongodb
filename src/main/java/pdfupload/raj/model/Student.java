package pdfupload.raj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
@Document("student")
public class Student {
	
	@Id
	private int id;
	private String name;
	private String data;
    private String search;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getsearch() {
		return search;
	}

	public void setsearch(String search) {
		this.search = search;
	}

	public String getData() {
		return search;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Student(int id, String name, String data,String search) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
		this.search = search;
	}

	public Student() {
		super();
	}

}
