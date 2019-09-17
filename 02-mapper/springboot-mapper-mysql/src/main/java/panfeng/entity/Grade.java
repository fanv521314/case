package panfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grade")
public class Grade
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer g_id;
    private String g_name;
    private List<Student> student_list;
}
