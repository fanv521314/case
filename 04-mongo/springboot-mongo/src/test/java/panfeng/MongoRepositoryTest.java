package panfeng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import panfeng.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoRepositoryTest
{
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 总体来说不太方便,没有 MongoTemplate 方便
     */

    /*测试数据 表名 student

    {"stu_name":"大牛哥哥","age":15,"grade_id":1}
    {"stu_name":"二蛋","age":11,"grade_id":2}
    {"stu_name":"三驴","age":18,"grade_id":3}
    {"stu_name":"四毛","age":18,"grade_id":1}
    {"stu_name":"五虎","age":20,"grade_id":2}
    {"stu_name":"六豹子","age":13,"grade_id":3}
    {"stu_name":"六豹子","age":17,"grade_id":3}
    {"stu_name":"豹","age":11,"grade_id":3}

     */

    @Test
    public void select()
    {
        //查询所有 *
//        studentRepository.findAll().forEach(System.out::println);
        //查询所有并按照年龄排序
//        Sort sort = new Sort(Sort.Direction.ASC, "age");
//        studentRepository.findAll(sort).forEach(System.out::println);
        //分页 每页2条 查询第二页
//        PageRequest pageRequest = new PageRequest(1, 2);//page 0第一页 1第二页
//        studentRepository.findAll(pageRequest).forEach(System.out::println);
        //根据名称查询 stu_name='六豹子'
//        studentRepository.findStudentsByStu_name("六豹子").forEach(System.out::println);
        //模糊查询 stu_name like '%豹%'
//        studentRepository.findStudentsByStu_nameBetween("豹").forEach(System.out::println);
        //模糊查询以什么开头 stu_name like '豹%'
//        studentRepository.findStudentsByStu_nameStartingWith("豹").forEach(System.out::println);
        //查询 stu_name=六豹子 and age=13
//        studentRepository.findStudentsByStu_nameaAndAge("六豹子",13).forEach(System.out::println);
    }
}