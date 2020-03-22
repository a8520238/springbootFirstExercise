package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface studentService {
    public List<Student> selectAll();

    public int update();
}
