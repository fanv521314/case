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

        System.out.println("1111" + user);

        // 对密码加密
        user.setU_password(CodecUtils.md5Hex(user.getU_password(), salt));
        user.setCreate_time(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        System.out.println("2222" + user);
        return this.userMapper.insert(user) == 1;
    }

    public User queryUser(String username, String password)
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
}
