package panfeng.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import panfeng.config.SmsProperties;
import panfeng.entity.Grade;
import panfeng.entity.Student;
import panfeng.service.StudentService;
import panfeng.utils.PageResult;
import panfeng.utils.SmsUtils;

import java.util.Map;

@Controller
@RequestMapping("student")

public class StudentController
{

    @Autowired
    private StudentService studentService;

    // http://localhost:1802/student
    // body > raw >json

    // {"s_name":"大牛","grade":{"g_id":"1"}}
    // {"s_name":"二蛋","grade":{"g_id":"2"}}
    // {"s_name":"三驴","grade":{"g_id":"3"}}
    // {"s_name":"四毛","grade":{"g_id":"1"}}
    // {"s_name":"五虎","grade":{"g_id":"2"}}
    @PostMapping
    public ResponseEntity<Void> insertStudent(@RequestBody(required = false) Student student)
    {
        if (studentService.insert(student) != 1)
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }


    // http://localhost:1802/student/all

    // http://localhost:1802/student/condition?s_id=1
    // http://localhost:1802/student/condition?s_name=大
    // http://localhost:1802/student/condition?g_id=1
    // http://localhost:1802/student/condition?g_id=1&s_name=四
    @GetMapping(value = {"all", "condition"})
    public ResponseEntity<PageResult<Student>> select_list
    (
            @RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,//当前页码
            @RequestParam(value = "rows", defaultValue = "5", required = false) Integer rows,//每页多少条数据
            @RequestParam(name = "s_id", required = false) Integer s_id,
            @RequestParam(name = "s_name", required = false) String s_name,
            @RequestParam(name = "g_id", required = false) Integer g_id
    )
    {
        PageResult<Student> student_page_result = studentService.select_list(currentPage, rows, s_id, s_name, g_id);
        if (student_page_result == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(student_page_result);
    }

    @DeleteMapping("{s_id}")
    public ResponseEntity<Void> delete(@PathVariable("s_id") Integer s_id)
    {
        if (studentService.delete(s_id)!=1)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}