package panfeng.mapper;

import panfeng.entity.Grade;
import panfeng.mybatis.MyMapper;

import java.util.List;

public interface GradeMapper extends MyMapper<Grade>
{
    List<Grade> select_all();
}
