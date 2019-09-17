package panfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import panfeng.entity.Grade;
import panfeng.mapper.GradeMapper;
import panfeng.service.GradeService;

import java.util.List;

@Controller
@RequestMapping("grade")
public class GradeController
{
    @Autowired
    private GradeService gradeService;

    /*
     * 描述:新增年级
     * 【时间 2019-08-19 16:10 作者 陶攀峰】
     */

    // http://localhost:1802/grade
    // {"g_name":"一年级"}
//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody(required = false) Grade grade)
//    {
//        if (gradeMapper.insert_grade(grade)!=1)
//        {
//            return ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.noContent().build();
//    }

    /*
     * 描述:查询所有年级
     * 【时间 2019-08-19 16:10 作者 陶攀峰】
     */
    // http://localhost:1802/grade/all
    @GetMapping("all")
    public ResponseEntity<List<Grade>> select_all()
    {
        List<Grade> grade_list = gradeService.select_all();
        if (CollectionUtils.isEmpty(grade_list))
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grade_list);
    }
}
