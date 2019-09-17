package panfeng.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import panfeng.config.SmsProperties;
import panfeng.utils.SmsUtils;

import java.util.Random;


@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsService
{
    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private SmsProperties smsProperties;

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsService.class);

    /**
     * 生成指定位数的随机数字
     *
     * @param len
     * @return
     */
    public static String generateCode(int len)
    {
        len = Math.min(len, 8);
        int min = Double.valueOf(Math.pow(10, len - 1)).intValue();
        int num = new Random().nextInt(Double.valueOf(Math.pow(10, len + 1)).intValue() - 1) + min;
        return String.valueOf(num).substring(0, len);
    }

    public String sendSms(String phone)
    {
        // 生成验证码 6位
        String code = generateCode(6);
        try
        {
            // 发送消息[电话号码,验证码,签名名称,模版CODE]
            //SendSmsResponse response = this.smsUtils.sendSms(phone, code, smsProperties.getSignName(), smsProperties.getVerifyCodeTemplate());
            return code;
        } catch (Exception e)
        {
            LOGGER.error("发送短信失败。phone：{}， code：{}", phone, code);
            return "";
        }
    }
}
