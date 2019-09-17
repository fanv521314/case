package panfeng.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer u_id;//主键
    @Length(min = 1, max = 12, message = "用户名只能在1~12位之间,[1,12]")
    private String u_username;//用户名
    @JsonIgnore//查询不会显示此属性     对象序列化为json字符串时,忽略该属性
    @Length(min = 6, max = 16, message = "密码只能在6~16位之间,[6,16]")
    private String u_password;//密码
    @Pattern(regexp = "^1[35678]\\d{9}$", message = "手机号格式不正确")
    private String u_phone;//电话
    @JsonIgnore
    private String u_salt;// 密码的盐值
    private String create_time;//创建时间
}