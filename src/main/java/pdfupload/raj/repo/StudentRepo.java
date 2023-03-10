package pdfupload.raj.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import pdfupload.raj.model.Student;

public interface StudentRepo extends MongoRepository<Student, Integer> {

	
	
	@Query (" {data:{$regex:?0}} ")
	List<Student> findByName(String name);


	
}
