package panfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
//@Table(name = "TPF_STUDENT")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Oracle需要注销此行
    private Integer s_id;
    private String s_name;
    private Grade grade;
}
