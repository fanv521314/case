package panfeng;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
        statement = connection.prepareStatement("INSERT INTO FLINK VALUES (SEQ_FLINK.NEXTVAL,?)");
    }

    // 2,执行
    @Override
    public void invoke(String value, Context context) throws Exception
    {
        System.out.println("value.toString()-------" + value.toString());
        statement.setString(1, value);
        statement.execute();
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
