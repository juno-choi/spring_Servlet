package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();  //바이트로 message body를 읽어옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//인코딩 정보

        System.out.println(messageBody);
        response.getWriter().write("ok");
    }
}
