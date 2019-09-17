package panfeng.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import panfeng.service.ProviderService;

@Component
@Service// org.apache.dubbo
public class ProviderServiceImpl implements ProviderService
{

    @Override
    public String provider_method()
    {
        return "我是provider...";
    }
}
