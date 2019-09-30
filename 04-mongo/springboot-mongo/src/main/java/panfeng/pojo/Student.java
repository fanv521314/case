package panfeng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "student")//对应表名
@Data//setter getter toString
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
public class Student
{
    @Id//主键
    private String id;
    @Field("stu_name")//对应列名
    private String stu_name;
    private Integer age;
    private Integer grade_id;
    private Grade grade;
}
