package panfeng.mapper;

import panfeng.entity.User;
import panfeng.mybatis.MyMapper;

public interface UserMapper extends MyMapper<User>
{
    Integer insert_user(User user);
}
