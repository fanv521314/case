package panfeng.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import panfeng.pojo.Student;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String>
{
    @Query("{'stu_name':?0}}")
    List<Student> findStudentsByStu_name(String stu_name);

    @Query("{'stu_name':{$regex:'?0'}}")
    List<Student> findStudentsByStu_nameBetween(String stu_name);

    @Query("{'stu_name':{$regex:'^?0'}}")
    List<Student> findStudentsByStu_nameStartingWith(String stu_name);

    @Query("{$and:[{'stu_name':?0},{'age':?1}]}")
    List<Student> findStudentsByStu_nameaAndAge(String stu_name,Integer age);
}