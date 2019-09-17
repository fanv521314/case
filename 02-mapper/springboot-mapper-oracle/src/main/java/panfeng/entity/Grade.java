package panfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TPF_GRADE")
public class Grade
{
    @Id
    private Integer g_id;
    private String g_name;
    private List<Student> student_list;
}
