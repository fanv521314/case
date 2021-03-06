package panfeng;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo// org.apache.dubbo
@SpringBootApplication
public class DubboProviderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DubboProviderApplication.class);
    }
}
