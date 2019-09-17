package panfeng.mapper;

import panfeng.entity.Grade;
import panfeng.mybatis.MyMapper;

import java.util.List;

public interface GradeMapper extends MyMapper<Grade>
{
    //Integer insert_grade(Grade grade);//Oracle

    List<Grade> select_all();
}
