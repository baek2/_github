package front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url 분석 : a.com / b.com
		System.out.println("url=" + request.getRequestURL());
		System.out.println("uri=" + request.getRequestURI());
		System.out.println("context(프로젝트명)=" + request.getContextPath());
		String uri = request.getRequestURI();
		String com = uri.split("/")[uri.split("/").length-1];
		CommandFactory factory = new CommandFactory();
		Command command = null;
		if(com.equals("a.com")){
			//new ACommand().run();
			command = factory.getCommand("a");
		}
		else if(com.equals("b.com")){
			command = factory.getCommand("b");
		}
		else if(com.equals("c.com")){
			command = factory.getCommand("c");
		}
		else{
			System.out.println("해당 요청 처리 코맨드 없음");
		}
		command.run();
	}
}
