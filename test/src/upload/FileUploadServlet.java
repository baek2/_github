package upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUploadServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //요청 : server.xml
      //enctype="multipart/form-data" 파일을 전체 덩어리로 보면 됨! 그래서 파라미터로 못불러옴
      String name = request.getParameter("name");
      String uploadfile = request.getParameter("uploadfile"); //파일 이름만 읽어옴
      InputStream is = request.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));//BufferedReader 타입은 buffered 타입으로만 받기 때문에 맞게 바꿔줘야됨.
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      //br 입력 --- out 출력
      String line = null; // 한줄한줄 읽어오게 하는거
      while((line = br.readLine()) != null) {
         //읽을게 없으면 null이 뜸
         out.println(line+"<br>");
      }
      
      out.println("전송데이터길이=" + request.getContentLength());
      out.println("전송데이터타입=" + request.getContentType());
      //처리
      //응답
   }

}