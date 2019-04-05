package com.bpeak.Dao;

import com.bpeak.Entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;

@Repository
public class StudentDao {

    public Collection<Student> getAllStudents(){
        HashMap<Integer, Student> students  = new HashMap();
        try{
            Connection conn = DB.connect();
            Statement stmt = conn.createStatement();
            String sql = "select * from students";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String course = rs.getString(3);
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setCourse(course);
                students.put(id, student);
            }
        } catch (Exception e){

        }
        return students.values();
    }

    public Student getStudentById(int id){
        Student student = new Student();
        try{
            Connection conn = DB.connect();
            String sql = "select * from students where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setCourse(rs.getString(3));
            }
        } catch (Exception e){

        }
        return student;
    }

    public void updateStudentById(Student student){
        try{
            Connection conn = DB.connect();
            String sql = "update students set id = ?, name = ?, course = ? where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getCourse());
            pstmt.setInt(4, student.getId());
            int count = pstmt.executeUpdate();
        } catch ( Exception e ){

        }
    }

//    public void updateStudentById(Student student){
//        Student updatedStudent = students.get(student.getId());
//        updatedStudent.setName(student.getName());
//        updatedStudent.setCourse(student.getCourse());
//        students.put(student.getId(), updatedStudent);
//    }

    public void removeStudentById(int id){
        try{
            Connection conn = DB.connect();
            String sql = "delete from students where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int count = pstmt.executeUpdate();
        } catch (Exception e){

        }
    }

    public void insertStudent(Student student){
        try{
            Connection conn = DB.connect();
            String sql = "insert into students(id, name, course) values(?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getCourse());
            int count = pstmt.executeUpdate();


        } catch (Exception e){

        }
    }
}
