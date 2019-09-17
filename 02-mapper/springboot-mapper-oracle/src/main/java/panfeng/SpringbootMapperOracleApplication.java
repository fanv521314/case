package panfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("panfeng.mapper")
@SpringBootApplication
public class SpringbootMapperOracleApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootMapperOracleApplication.class, args);
    }

}
