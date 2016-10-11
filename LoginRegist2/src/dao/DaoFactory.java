package dao;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by codingBoy on 16/10/11.
 */
public class DaoFactory
{
    private static Properties properties=null;

    static
    {
        //家在配置文件到properties文件中
        try {
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            properties = new Properties();
            properties.load(in);
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
    }
    //返回一个具体实现UserDao的实现类
    public static UserDao getUserDao() {
        /*
         *给出一个配置文件，文件中给出UserDao接口的实现类名称
         * 我们这个方法，获取实现类的类名，通过反射创建对象
         */

        try{
            Class clazz = Class.forName(properties.getProperty("dao.UserDao"));
            return (UserDao) clazz.newInstance();
        }catch (Exception e) {
             throw new RuntimeException(e);
         }

    }
}
