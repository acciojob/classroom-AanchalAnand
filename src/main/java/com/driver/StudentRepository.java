package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StudentRepository {
    private HashMap<String,Student> studentRecord;
    private HashMap<String,Teacher> teacherRecord;
    private HashMap<String, List<String>> pair;

    public StudentRepository() {
        this.studentRecord = new HashMap<>();
        this.teacherRecord = new HashMap<>();
        this.pair = new HashMap<>();
    }
    public void addStudent(Student student){
        studentRecord.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherRecord.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String sname,String tname){
        if(studentRecord.containsKey(sname) && teacherRecord.containsKey(tname)){
            studentRecord.put(sname,studentRecord.get(sname));
            teacherRecord.put(tname,teacherRecord.get(tname));
            List<String> list=new ArrayList<>();
            if(pair.containsKey(tname))
                list=pair.get(tname);
            list.add(sname);
            pair.put(tname,list);
        }
    }
    public Student getStudentByName(String sname){
        return studentRecord.get(sname);
    }
    public Teacher getTeacherByName(String tname){
        return teacherRecord.get(tname);
    }
    public List<String> getStudentsByTeacherName(String tname){
        List<String> list=new ArrayList<>();
        if(pair.containsKey(tname)){
            list=pair.get(tname);
        }
        return list;
    }
    public List<String> getAllStudents(){
        return new ArrayList<>(studentRecord.keySet());
    }
    public void deleteTeacherBy(String tname){
        List<String> list=new ArrayList<>();
        if(pair.containsKey(tname)){
            list=pair.get(tname);
            for(String name:list){
                if(studentRecord.containsKey(name))
                    studentRecord.remove(name);
            }
            pair.remove(tname);
        }
        if(pair.containsKey(tname)){
            teacherRecord.remove(tname);
        }
    }
    public void deleteAllTeachers(){
        HashSet<String> set=new HashSet<>();
        for(String tname: pair.keySet()){
            for(String sname:pair.get(tname))
                set.add(sname);
        }
        for(String sname:set){
            if(studentRecord.containsKey(sname))
                studentRecord.remove(sname);
        }
    }
}
