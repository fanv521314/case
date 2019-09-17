package panfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//导包注意 import tk.mybatis.spring.annotation.MapperScan;
@MapperScan("panfeng.mapper")
@SpringBootApplication
public class SpringbootMapperApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootMapperApplication.class, args);
    }

}
