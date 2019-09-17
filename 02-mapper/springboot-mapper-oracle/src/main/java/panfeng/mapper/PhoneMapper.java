package panfeng.mapper;

import panfeng.entity.Phone;
import panfeng.mybatis.MyMapper;

public interface PhoneMapper extends MyMapper<Phone>
{
    Integer insert_phone(Phone phone);
}