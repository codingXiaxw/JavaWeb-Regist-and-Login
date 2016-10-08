package util;

/**
 * Created by codingBoy on 16/10/8.
 */
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * Created by codingBoy on 16/10/8.
 */
public class CommonUtils
{
    public static String uuid()
    {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    public static<T> T toBean(Map map,Class<T> clazz)
    {
        try
        {
            T bean=clazz.newInstance();
            BeanUtils.populate(bean,map);
            return bean;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }
}
