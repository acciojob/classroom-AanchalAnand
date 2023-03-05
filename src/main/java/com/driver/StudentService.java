package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String sname,String tname){
        studentRepository.addStudentTeacherPair(sname,tname);
    }
    public Student getStudentByName(String sname){
        return studentRepository.getStudentByName(sname);
    }
    public Teacher getTeacherByName(String tname){
        return studentRepository.getTeacherByName(tname);
    }
    public List<String> getStudentsByTeacherName(String tname){
        return studentRepository.getStudentsByTeacherName(tname);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public void deleteTeacherBy(String tname){
        studentRepository.deleteTeacherBy(tname);
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
