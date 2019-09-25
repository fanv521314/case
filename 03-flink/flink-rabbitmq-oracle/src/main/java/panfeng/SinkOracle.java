package panfeng;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SinkOracle extends RichSinkFunction<String>
{
    private Connection connection;
    private PreparedStatement statement;

    // 1,初始化
    @Override
    public void open(Configuration parameters) throws Exception
    {
        super.open(parameters);
        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "123456");
    }

    // 2,执行
    @Override
    public void invoke(String value, Context context) throws Exception
    {
        //引入依赖 fastjson
        //JSONObject jsonObject = JSON.parseObject(value);//字符串 -> JSON对象
        //Object object = JSONObject.toJavaObject(jsonObject, Object.class);// JSON对象 -> Java对象 这里的Object就是你要转换的类

        System.out.println("接收到消息-------\n" + value);
        statement = connection.prepareStatement("INSERT INTO FLINK VALUES (SEQ_FLINK.NEXTVAL,?)");
        statement.setString(1, value);//1表示第一个?
        if (statement.executeUpdate() > 0)
        {
            System.out.println("执行成功...");
        } else
        {
            System.out.println("执行失败...");
        }

        //-----------------------------------
        ResultSet rs = connection.prepareStatement("SELECT * FROM FLINK").executeQuery();
        while (rs.next())
        {
            int id = rs.getInt(1);//1表示第一列
            String name = rs.getString(2);
            System.out.println(id + "---" + name);
        }
    }

    // 3,关闭
    @Override
    public void close() throws Exception
    {
        super.close();
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }
}

/*
# 创建序列
CREATE SEQUENCE SEQ_FLINK
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

# 删除序列
DROP SEQUENCE SEQ_FLINK;
 */
