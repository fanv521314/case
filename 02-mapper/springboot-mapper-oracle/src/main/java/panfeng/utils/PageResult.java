package panfeng.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * 描述:分页
 * 【时间 2019-08-20 08:06 作者 陶攀峰】
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T>
{
    private Long totalNum;// 总条数
    private Integer totalPage;// 总页数
    private List<T> itemList;// 当前页数据
}