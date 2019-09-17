package panfeng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panfeng.entity.User;
import panfeng.mapper.UserMapper;
import panfeng.utils.CodecUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService
{
    @Autowired
    private UserMapper userMapper;

    public Boolean register(User user)
    {
        // 生成盐 >>> 随机生成UUID 并且把生成的UUID的 减号"-" 替换为 空""
        String salt = CodecUtils.generateSalt();
        user.setU_salt(salt);

        // 对密码加密
        user.setU_password(CodecUtils.md5Hex(user.getU_password(), salt));
        user.setCreate_time(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        return this.userMapper.insert_user(user) == 1;
    }

    public User login(String username, String password)
    {
        // 查询
        User user = new User();
        user.setU_username(username);
        User return_user = this.userMapper.selectOne(user);
        // 根据用户名查不到用户
        if (return_user == null)
        {
            return null;
        }
        // 校验密码
        if (!return_user.getU_password().equals(CodecUtils.md5Hex(password, return_user.getU_salt())))
        {
            return null;
        }
        // 用户名密码都正确 返回对象
        return return_user;
    }

    public User query(User user)
    {
        return userMapper.selectOne(user);
    }

    // public Boolean register(User user, String code)
    //    {
    //        // 校验短信验证码
    //        String cacheCode = this.redisTemplate.opsForValue().get(KEY_PREFIX + user.getPhone());
    //        //code为用户输入的验证码 与 Redis存的验证码进行比较
    //        if (!StringUtils.equals(code, cacheCode))
    //        {
    //            //不一致,返回false,验证码错误
    //            return false;
    //        }
    //
    //        // 生成盐 >>> 随机生成UUID 并且把生成的UUID的 减号"-" 替换为 空""
    //        String salt = CodecUtils.generateSalt();
    //        user.setSalt(salt);
    //
    //        // 对密码加密
    //        user.setPassword(CodecUtils.md5Hex(user.getPassword(), salt));
    //
    //        // 强制设置主键为null,使其自增
    //        user.setId(null);
    //        user.setCreated(new Date());
    //        // 添加到数据库
    //        boolean bool = this.userMapper.insertSelective(user) == 1;
    //
    //        if (bool)
    //        {
    //            // 注册成功，删除redis中的记录
    //            this.redisTemplate.delete(KEY_PREFIX + user.getPhone());
    //        }
    //        return bool;
    //    }

    // 查询
    //        User user = new User();
    //        user.setUsername(username);
    //        User return_user = this.userMapper.selectOne(user);
    //        // 校验用户名
    //        if (return_user == null)
    //        {
    //            return null;
    //        }
    //        // 校验密码
    //        if (!return_user.getPassword().equals(CodecUtils.md5Hex(password, return_user.getSalt())))
    //        {
    //            return null;
    //        }
    //        // 用户名密码都正确 返回对象
    //        return return_user;
}
