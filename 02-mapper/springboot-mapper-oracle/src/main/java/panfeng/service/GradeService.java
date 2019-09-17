package panfeng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panfeng.entity.Grade;
import panfeng.mapper.GradeMapper;
import panfeng.mapper.StudentMapper;

import java.util.List;

@Service
public class GradeService
{
    @Autowired
    private GradeMapper gradeMapper;

    public List<Grade> select_all()
    {
        return gradeMapper.select_all();
    }
}
