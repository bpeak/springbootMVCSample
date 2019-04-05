package com.bpeak.Service;

import com.bpeak.Dao.StudentDao;
import com.bpeak.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
    public Student getStudentById(int id){
        // case by case process
        // business logic here
        return studentDao.getStudentById(id);
    }

    public void updateStudentById(Student student){
        this.studentDao.updateStudentById(student);
    }

    public void removeStudentById(int id){
        this.studentDao.removeStudentById(id);
    }

    public void insertStudent(Student student){
        this.studentDao.insertStudent(student);
    }
}
