package panfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TPF_PHONE")
public class Phone
{
    @Id
    private Integer p_id;
    private String p_phone;
    private String p_code;
}
