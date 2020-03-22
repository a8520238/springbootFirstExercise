package com.example.demo.service.impl;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Override
    //public synchronized List<Student> selectAll() {
    public synchronized List<Student> selectAll() {
        //字符串序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发环境下，这种会出现缓存穿透 第一种办法类的前面加上synchronized 第二种在后面查询 双重检测
        //查询缓存
        List<Student> studentList = (List<Student>) redisTemplate.
                opsForValue().get("allStudents");

        if (studentList == null) {
            synchronized (this) {
                studentList = (List<Student>) redisTemplate.
                        opsForValue().get("allStudents");
                if (studentList == null) {
                    studentList = studentMapper.selectAll();
                    redisTemplate.opsForValue().set("allStudents", studentList);
                }
            }
        }
        return studentList;
    }

    @Override
    @Transactional
    public int update() {
        Student student = new Student();
        student.setId(1);
        student.setName("李四-update");
        student.setSex("m");
        int update = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println(update);

        //此处会抛出异常，发生回滚
        //int a = 10/0;
        return update;
    }
}
