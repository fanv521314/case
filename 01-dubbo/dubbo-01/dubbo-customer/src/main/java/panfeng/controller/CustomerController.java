package panfeng.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import panfeng.service.CustomerService;
import panfeng.service.ProviderService;

@Controller
@RequestMapping("customer")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @Reference// org.apache.dubbo
    private ProviderService providerService;

    // localhost:8082/customer/hello
    @GetMapping("hello")
    public ResponseEntity<String> customer_hello()
    {
        System.out.println(providerService.provider_method());
        return ResponseEntity.ok(customerService.customer_method());
    }
}
