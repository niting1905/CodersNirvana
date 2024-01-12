package com.example.Rest.controller.redis;

import com.example.Rest.redis.model.Student;
import com.example.Rest.redis.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    StudentRepo studentRepository;


    @PutMapping("/redisKV")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        System.out.println("In side the controller");
        //kafkaProducer.sendMessage(message);
        pojoUtil();
        Student retrievedStudent =
                studentRepository.findById("Eng2015001").get();

        return ResponseEntity.ok(retrievedStudent.id +"" + retrievedStudent.name);
    }

    private void pojoUtil(){

        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
    }
}
