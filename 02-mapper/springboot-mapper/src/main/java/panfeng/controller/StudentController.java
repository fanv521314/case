package panfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import panfeng.entity.Grade;
import panfeng.entity.Student;
import panfeng.mapper.StudentMapper;
import panfeng.utils.PageResult;

@Controller
@RequestMapping("student")
public class StudentController
{

    @Autowired
    private StudentMapper studentMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @PostMapping
    // http://localhost:1801/student
    // body > raw >json

    // {"s_name":"大牛","grade":{"g_id":"1"}}
    // {"s_name":"二蛋","grade":{"g_id":"2"}}
    // {"s_name":"三驴","grade":{"g_id":"3"}}
    // {"s_name":"四毛","grade":{"g_id":"1"}}
    // {"s_name":"五虎","grade":{"g_id":"2"}}
    public ResponseEntity<Void> insertStudent(@RequestBody(required = false) Student student)
    {
        if (studentMapper.insert(student) != 1)
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = {"all", "condition"})
    // http://localhost:1801/student/all

    // http://localhost:1801/student/condition?s_id=1
    // http://localhost:1801/student/condition?s_name=大
    // http://localhost:1801/student/condition?g_id=1
    // http://localhost:1801/student/condition?g_id=1&s_name=四
    public ResponseEntity<PageResult<Student>> select_list
            (
                    @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,//当前页码
                    @RequestParam(value = "rows", defaultValue = "2") Integer rows,//每页多少条数据
                    @RequestParam(name = "s_id", required = false) Integer s_id,
                    @RequestParam(name = "s_name", required = false) String s_name,
                    @RequestParam(name = "g_id", required = false) Integer g_id
            )
    {
        PageResult<Student> result;

        try
        {
            PageHelper.startPage(currentPage, rows);
            Grade grade = new Grade(g_id, null, null);
            Student student = new Student(s_id, s_name, grade);
            Page<Student> pageInfo = (Page<Student>) studentMapper.select_list(student);
            result = new PageResult<>(pageInfo.getTotal(), null, pageInfo);
        } catch (Exception e)
        {
            LOGGER.error("获取学生信息出错");
            result = null;
        }


        if (result == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(result);
    }
}