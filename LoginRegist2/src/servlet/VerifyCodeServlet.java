package servlet;

import util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by codingBoy on 16/10/8.
 */
public class VerifyCodeServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerifyCode vc=new VerifyCode();
        BufferedImage image=vc.getImage();
        request.getSession().setAttribute("session_vcode",vc.getText());
        VerifyCode.output(image,response.getOutputStream());
    }
}
