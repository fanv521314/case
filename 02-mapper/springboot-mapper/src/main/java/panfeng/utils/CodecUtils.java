package panfeng.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/*
 * 描述:加密工具类 需导包
 *
 *
 *     //        <dependency>
    //            <groupId>commons-codec</groupId>
    //            <artifactId>commons-codec</artifactId>
    //        </dependency>
 * 【时间 2019-07-30 15:34 作者 陶攀峰】
 */
public class CodecUtils
{

    /*
     * 描述:MD5 加密
     * 【时间 2019-08-20 09:59 作者 陶 攀  峰】
     */
    public static String md5Hex(String data, String salt)
    {
        if (StringUtils.isBlank(salt))
        {
            //如果盐为空 盐就是密码的hashCode值
            salt = data.hashCode() + "";
        }
        //盐=UUID去减号
        //返回 对盐+MD5十六进制加密(密码)之后的结果>再进行一次MD5的十六进制加密
        return DigestUtils.md5Hex(salt + DigestUtils.md5Hex(data));
    }

    /*
     * 描述:SHA 加密
     * 【时间 2019-08-20 09:59 作者 陶攀峰】
     */
    public static String shaHex(String data, String salt)
    {
        if (StringUtils.isBlank(salt))
        {
            salt = data.hashCode() + "";
        }
        return DigestUtils.sha512Hex(salt + DigestUtils.sha512Hex(data));
    }

    /*
     * 描述:生成盐(随机生成UUID 并且把生成的UUID的 减号"-" 替换为 空"")
     * 【时间 2019-07-30 15:48 作者 陶 攀 峰】
     */
    public static String generateSalt()
    {
        return StringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }
}
