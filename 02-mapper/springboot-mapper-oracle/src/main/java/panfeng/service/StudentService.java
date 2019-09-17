package panfeng.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panfeng.entity.Grade;
import panfeng.entity.Student;
import panfeng.mapper.StudentMapper;
import panfeng.utils.PageResult;

@Service
public class StudentService
{
    @Autowired
    private StudentMapper studentMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    public PageResult<Student> select_list(Integer currentPage, Integer rows, Integer s_id, String s_name, Integer g_id)
    {
        try
        {
            PageHelper.startPage(currentPage, rows);
            Grade grade = new Grade(g_id, null, null);
            Student student = new Student(s_id, s_name, grade);
            Page<Student> student_page = (Page<Student>) studentMapper.select_list(student);
            return new PageResult<>(student_page.getTotal(), null, student_page);
        } catch (Exception e)
        {
            LOGGER.error("获取学生信息出错", e);
            return null;
        }
    }

    public Integer insert(Student student)
    {
        return studentMapper.insert_student(student);
    }

    public Integer delete(Integer s_id)
    {
        return studentMapper.deleteByPrimaryKey(s_id);
    }
}
