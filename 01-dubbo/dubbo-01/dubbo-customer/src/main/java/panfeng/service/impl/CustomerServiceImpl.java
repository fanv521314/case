package panfeng.service.impl;

import org.springframework.stereotype.Component;
import panfeng.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService
{
    @Override
    public String customer_method()
    {
        return "我是customer...";
    }
}
