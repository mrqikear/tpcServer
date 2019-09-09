package Dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DaoFactory {
    private  static  String resource = "mybatis-config.xml";
    private Object mapper;
    private SqlSession sqlSession;

    public DaoFactory(){}

    public  DaoFactory(Object daoClass) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory
        SqlSessionFactory sqlFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        this.setSqlSession(sqlFactory.openSession());
        //获得相应的mapper映射文件
        Object mapper = this.sqlSession.getMapper((Class<Object>) daoClass);
        this.setMapper(mapper);

    }

    public Object getMapper() {
        return mapper;
    }

    public void setMapper(Object mapper) {
        this.mapper = mapper;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public void  commit( ){
        this.sqlSession.commit();
    }


    public void close(){
        this.sqlSession.close();
    }
}
