package panfeng;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.rabbitmq.RMQSource;
import org.apache.flink.streaming.connectors.rabbitmq.common.RMQConnectionConfig;

public class FlinkMain
{
    public static void main(String[] args) throws Exception
    {
        // 1,执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 2,RabbitMQ配置
        RMQConnectionConfig connectionConfig = new RMQConnectionConfig.Builder()
                .setHost("192.168.1.3")
                .setPort(5673)
                .setUserName("panfeng")
                .setPassword("panfeng")
                .setVirtualHost("/panfeng")
                .build();

        // 3,添加资源,RMQSource(OUT)
        DataStreamSource<String> dataStreamSource = env.addSource(new RMQSource<String>(
                connectionConfig,
                "flink",
                true,
                new SimpleStringSchema()));

        // 4,添加到流,去执行接收到的数据进行入库,addSink(IN)
        dataStreamSource.addSink(new SinkOracle());

        // 5,执行工作,定义一个工作名称
        env.execute("rabbitmq flink oracle");
    }
}