package nonspringmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hello.mvc, board.mvc
		//Controller 인터페이스 : HelloController호출, BoardController 호출
		//메소드 호출
		//1. uri 분석 : 요청 분석
		String path = request.getRequestURI();
		String parse[] = path.split("/");
		String result = parse[parse.length-1];
		//2. uri - controller 매핑 규칙 객체
		//url(키),컨트롤러(값):map, factory
		HandlerMapping mapping = new HandlerMapping();
		//3. controller 선정
		Controller controller = mapping.getController(result);
		//4. controller 코맨드 실행(model, view)
		String view = controller.handleRequest(request, response);
		//5. forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
}
