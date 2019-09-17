package panfeng.mapper;

import panfeng.entity.Student;
import panfeng.mybatis.MyMapper;

import java.util.List;

public interface StudentMapper extends MyMapper<Student>
{
    List<Student> select_list(Student student);

    Integer insert_student(Student student);
}