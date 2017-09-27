package nonspringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response){
		//Model 선정실행
		request.setAttribute("message", "hello mvc");
		//request.getAttribute("message") ${message}
		
		//view 선정 
		return "hello.jsp";
	}
}
