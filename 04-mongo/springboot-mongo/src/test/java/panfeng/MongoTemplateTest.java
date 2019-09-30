package panfeng;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.sun.beans.decoder.ValueObject;
import org.bson.BsonDocument;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;
import panfeng.pojo.Grade;
import panfeng.pojo.Student;
import panfeng.repository.StudentRepository;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTemplateTest
{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insert() throws Exception
    {
        //插入学生数据
//        mongoTemplate.save(new Student(null, "大牛哥哥", 15, 1, null));
//        mongoTemplate.save(new Student(null, "二蛋", 11, 2, null));
//        mongoTemplate.save(new Student(null, "三驴", 18, 3, null));
//        mongoTemplate.save(new Student(null, "四毛", 18, 1, null));
//        mongoTemplate.save(new Student(null, "五虎", 20, 2, null));
//        mongoTemplate.save(new Student(null, "六豹子", 13, 3, null));
//        mongoTemplate.save(new Student(null, "六豹子", 17, 3, null));
//        mongoTemplate.save(new Student(null, "豹", 11, 3, null));
        //插入年级数据
//        mongoTemplate.save(new Grade(null,1,"一年级"));
//        mongoTemplate.save(new Grade(null,2,"二年级"));
//        mongoTemplate.save(new Grade(null,3,"三年级"));
        //插入学生 -> Document模式
//        Document document=new Document()
//                .append("stu_name","陶攀峰")
//                .append("age",26)
//                .append("grade_id",4);
//        mongoTemplate.save(document,"student");
    }

    @Test
    public void delete() throws Exception
    {
        //删除所有grade_id=3
//        Query query = Query.query(Criteria.where("grade_id").is(3));
//        DeleteResult deleteResult = mongoTemplate.remove(query, Student.class);
//        System.out.println(deleteResult.getDeletedCount());//删除的数量
        //删除全部
//        DeleteResult deleteResult = mongoTemplate.remove(new Query(), Student.class);
//        System.out.println(deleteResult.getDeletedCount());//删除的数量
        //删除所有 age=4 -> 表 student
//        Query query = Query.query(Criteria.where("age").is(4));
//        DeleteResult deleteResult = mongoTemplate.remove(query, "student");
//        System.out.println(deleteResult.getDeletedCount());//删除的数量
    }

    @Test
    public void update() throws Exception
    {
        //修改stu_name="三驴" and age!=18的第一条记录 -> stu_name="三驴弟弟",age=18
//        Query query=Query.query(Criteria.where("stu_name").is("三驴").and("age").ne(18));
//        Update update = new Update().set("stu_name", "三驴弟弟").set("age", 19);
//        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Student.class);
//        System.out.println(updateResult.getModifiedCount());//修改多少条
        //修改所有的address="9527" 如果不存在就插入字段,如果存在则修改,也会改变字段类型
//        Update update = new Update().set("address", "9527");
//        UpdateResult updateResult = mongoTemplate.updateMulti(new Query(), update, Student.class);
//        System.out.println(updateResult.getModifiedCount());//修改多少条
        //修改表 student 所有的stu_name="陶攀峰" ->  stu_name="陶攀峰1",age=27
//        Query query = Query.query(Criteria.where("stu_name").is("陶攀峰"));
//        Update update = new Update().set("stu_name", "陶攀峰1").set("age", 27);
//        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, "student");
//        System.out.println(updateResult.getModifiedCount());//修改多少条
    }

    @Test
    public void select() throws Exception
    {
        //查询对应Document
//        mongoTemplate.findAll(Document.class, "student").forEach(System.out::println);
        //查询所有的数据 -> 循环打印数据
//        mongoTemplate.findAll(Student.class).forEach(System.out::println);
//        System.out.println("共计" + mongoTemplate.findAll(Student.class).size() + "条...");
        //查询stu_name="三驴"
//        Query query=Query.query(Criteria.where("stu_name").is("三驴"));
//        mongoTemplate.find(query, Student.class).forEach(System.out::println);
        //查询age>18
//        Query query=Query.query(Criteria.where("age").gt(18));
//        mongoTemplate.find(query,Student.class).forEach(System.out::println);
        //查询stu_name="三驴" and age>16
//        Query query=Query.query(Criteria.where("stu_name").is("三驴").and("age").gt(16));
//        mongoTemplate.find(query,Student.class).forEach(System.out::println);
        //查询stu_name like '%牛%'
//        Query query = Query.query(Criteria.where("stu_name").regex("牛"));
//        mongoTemplate.find(query, Student.class).forEach(System.out::println);
        //查询stu_name like '五%'
//        Query query = Query.query(Criteria.where("stu_name").regex("^五"));
//        mongoTemplate.find(query, Student.class).forEach(System.out::println);
        //查询age>15 并且按照age 降序
//        Query query = Query.query(Criteria.where("age").gt(15)).with(new Sort(Sort.Direction.DESC, "age"));
//        mongoTemplate.find(query,Student.class).forEach(System.out::println);
        //查询排序并分页
//        Query query=new Query();
//        query.with(new Sort(Sort.Direction.ASC,"age"));//按照age升序
//        query.with(new PageRequest(1,3));//page 0第一页 1第二页 -> 3每页三条记录
//        mongoTemplate.find(query,Student.class).forEach(System.out::println);
        //查询去除前2条,再取前三条 -> 取第3 4 5 条记录
//        Query query=new Query();
//        query.skip(2);
//        query.limit(3);
//        mongoTemplate.find(query,Student.class).forEach(System.out::println);
        //查询去除前2条,再取前三条 -> 取第3 4 5 条记录 -> 返回 Document
//        Query query=new Query().skip(2).limit(3);
//        mongoTemplate.find(query,Document.class,"student").forEach(System.out::println);
    }

    @Test
    public void aggregation() throws Exception
    {
        //查询所有学生,并关联到对应的年级 -> 从表.主表字段.从表字段.添加主表字段名称
//        LookupOperation lookupOperation = Aggregation.lookup("grade", "grade_id", "grade_id", "grade");
//        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
//        //如果collection=主表名称
//        //Student.class是对应主表的类,输出类型
//        List<Student> student_list = mongoTemplate.aggregate(aggregation, "student", Student.class).getMappedResults();
//        student_list.forEach(System.out::println);
        //查询所有年级,并关联到对应的学生 -> 从表.主表字段.从表字段.添加主表字段名称
//        LookupOperation lookupOperation = Aggregation.lookup("student", "grade_id", "grade_id", "student_list");
//        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
//        //如果collection=主表名称
//        //Grade.class是对应主表的类,输出类型
//        List<Grade> grade_list = mongoTemplate.aggregate(aggregation, "grade", Grade.class).getMappedResults();
//        grade_list.forEach(System.out::println);
        //查询所有学生,并关联到对应的年级,输出Document -> 从表.主表字段.从表字段.添加主表字段名称
//        LookupOperation lookupOperation = Aggregation.lookup("grade", "grade_id", "grade_id", "grade");
//        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
//        List<Document> document_list = mongoTemplate.aggregate(aggregation, "student", Document.class).getMappedResults();
//        document_list.forEach(System.out::println);
//        document_list.forEach(document ->
//        {
//            System.out.println(document.get("age"));//输出age字段
//        });
        //管道过滤
//        //1,查询age>11
//        MatchOperation matchOperation = Aggregation.match(Criteria.where("age").gt(11));
//        //2,使student与grade匹配,将匹配到的grade添加到grade字段 -> 从表.主表字段.从表字段.添加主表字段名称
//        LookupOperation lookupOperation = Aggregation.lookup("grade", "grade_id", "grade_id", "grade");
//        //3,按照age升序
//        SortOperation sortOperation = Aggregation.sort(Sort.Direction.ASC, "age");
//        //4,去除前2个值
//        SkipOperation skipOperation = Aggregation.skip(2);
//        //5,查询前3个值
//        LimitOperation limitOperation = Aggregation.limit(3);
//        //6,按照age分组,取个别名age_group记录按age分组的数量
//        GroupOperation groupOperation = Aggregation.group("age").count().as("age_group");
//        //7,获取总记录数,取个别名count
//        CountOperation countOperation = Aggregation.count().as("count");
//        //Aggregation aggregation = Aggregation.newAggregation(groupOperation);
//        //Aggregation aggregation = Aggregation.newAggregation(countOperation);
//        Aggregation aggregation = Aggregation.newAggregation(matchOperation, lookupOperation, sortOperation, skipOperation, limitOperation);
//        //如果collection=主表名称
//        //Document.class是对应输出类型
//        List<Document> document_list = mongoTemplate.aggregate(aggregation, "student", Document.class).getMappedResults();
//        document_list.forEach(System.out::println);
    }

    @Test
    public void mapReduce() throws Exception
    {
        /*测试数据 表名 a
        {_id:1,sku_id:"a",stock:11}
        {_id:2,sku_id:"b",stock:22}
        {_id:3,sku_id:"c",stock:33}
        {_id:4,sku_id:"d",stock:44}
        {_id:5,sku_id:"e",stock:55}
        {_id:6,sku_id:"a",stock:66}
        {_id:7,sku_id:"b",stock:77}
        {_id:8,sku_id:"c",stock:88}
        {_id:9,sku_id:"d",stock:99}
        */
//        mongoTemplate.mapReduce("article_info",  "classpath:map.js",
//                "classpath:reduce.js", options, ValueObject.class);
        //方式1
//        String map = "function(){" +
//                "emit(this.sku_id,this.stock);" +
//                "};";
//        String reduce = "function(k,v){" +
//                "return Array.sum(v);" +
//                "};";
//        mongoTemplate.mapReduce("a", map, reduce, Document.class).forEach(System.out::println);
//输出
//        Document{{_id=a, value=77.0}}
//        Document{{_id=b, value=99.0}}
//        Document{{_id=c, value=121.0}}
//        Document{{_id=d, value=143.0}}
//        Document{{_id=e, value=55.0}}
        //方式2
//        String map = "function(){" +
//                "emit(this.sku_id,this.stock);" +
//                "};";
//        String reduce = "function(k,v){" +
//                "return {'k1':k,'v1':v,'sum':Array.sum(v)};" +
//                "};";
//        mongoTemplate.mapReduce("a", map, reduce, Document.class).forEach(System.out::println);
//输出
//        Document{{_id=a, value=Document{{k1=a, v1=[11.0, 66.0], sum=77.0}}}}
//        Document{{_id=b, value=Document{{k1=b, v1=[22.0, 77.0], sum=99.0}}}}
//        Document{{_id=c, value=Document{{k1=c, v1=[33.0, 88.0], sum=121.0}}}}
//        Document{{_id=d, value=Document{{k1=d, v1=[44.0, 99.0], sum=143.0}}}}
//        Document{{_id=e, value=55.0}}
        //方式3 -> query map reduce finalize
//        String map = "function(){" +//this对应传入的表
//                "emit(this.sku_id,this.stock);" +
//                "};";
//        String reduce = "function(k1,v1){" +//function(k1,v1) 对应 map的emit(k,v) -> k1=sku_id v1=stock
//                "return {'k1':k1,'v1':v1,'sum':Array.sum(v1)};" +//添加sum字段记录总数
//                "};";
//        Query query=Query.query(Criteria.where("stock").ne(55));
//        String finalize="function(k2,v2){" +// k2=k1 v2=reduce的ruturn
//                "v2.avg=v.sum/v2.v1.length;" +//添加字段计算平均值
//                "return v2;}";
//        MapReduceOptions mapReduceOptions=new MapReduceOptions().finalizeFunction(finalize);
//        mongoTemplate.mapReduce(query,"a",map,reduce,mapReduceOptions,Document.class).forEach(System.out::println);
//输出
//        Document{{_id=a, value=Document{{k1=a, v1=[11.0, 66.0], sum=77.0, avg=38.5}}}}
//        Document{{_id=b, value=Document{{k1=b, v1=[22.0, 77.0], sum=99.0, avg=49.5}}}}
//        Document{{_id=c, value=Document{{k1=c, v1=[33.0, 88.0], sum=121.0, avg=60.5}}}}
//        Document{{_id=d, value=Document{{k1=d, v1=[44.0, 99.0], sum=143.0, avg=71.5}}}}
    }
}