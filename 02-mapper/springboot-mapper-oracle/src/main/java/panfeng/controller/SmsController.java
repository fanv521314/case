package panfeng.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import panfeng.service.SmsService;

@Controller
@RequestMapping("sms")
public class SmsController
{

    @Autowired
    private SmsService smsService;

    /**
     * 发送手机验证码
     *
     * @param phone
     * @return
     */
    // 测试 localhost:1801/send?phone=手机号码
    @PostMapping("send")
    public ResponseEntity<String> sendSms(String phone)
    {
        String code = this.smsService.sendSms(phone);
        if (StringUtils.isBlank(code))
        {
            //500
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //201
        return ResponseEntity.ok(code);
    }


}
