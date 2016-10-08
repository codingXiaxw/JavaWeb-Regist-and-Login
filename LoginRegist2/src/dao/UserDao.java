package dao;

import domain.User;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * Created by codingBoy on 16/10/7.
 */
public class UserDao
{
    String file="/Users/codingBoy/JavaWeb-Regist-and-Login/LoginRegist2/web/user/dom4j.xml";
    public User findByUsername(String username)
    {

        SAXReader reader=new SAXReader();

        try {
            Document document=reader.read(file);
            Element element= (Element) document.selectSingleNode("//user[@username='"+username+"']");


            if (element==null) return null;
            User user=new User();
            String uname=element.attributeValue("username");
            String password=element.attributeValue("password");
            user.setUsername(uname);
            user.setPassword(password);
            return user;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void add(User user)
    {
        SAXReader reader=new SAXReader();
        XMLWriter writer=null;
        try
        {
            Document document=reader.read(file);
            Element rootElement=document.getRootElement();
            Element userElement =rootElement.addElement("user");
            userElement.addAttribute("username",user.getUsername());
            userElement.addAttribute("password",user.getPassword());

            OutputFormat format=new OutputFormat("\t",true);
            format.setTrimText(true);
            writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"),format);
            writer.write(document);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

