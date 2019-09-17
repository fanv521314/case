package panfeng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/*
 * 描述:配置跨域
 * 【时间 2019-08-23 10:52 作者 陶 攀 峰】
 */
@Configuration
public class MyCors
{
    @Bean
    // import org.springframework.web.filter.CorsFilter;
    public CorsFilter corsFilter()
    {
        CorsConfiguration config = new CorsConfiguration();
        // 添加允许信任域名
        // 1) 允许跨域的域名,不要写*，否则cookie就无法使用了,*表示所有域名都可跨域访问
        // live-server --port=1802
        config.addAllowedOrigin("http://localhost:1802");
        config.addAllowedOrigin("http://127.0.0.1:1802");
        // 2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        // 3) 允许的请求方式
        // *表示所有请求方式:GET POST DELETE PUT...
        config.addAllowedMethod("*");
        // 4) 允许的头信息
        config.addAllowedHeader("*");
        // 初始化cors数据源对象
        // import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", config);
        // 返回CorsFilter实例,参数:cors配置源对象
        return new CorsFilter(configurationSource);
    }
}