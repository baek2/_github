package nonspringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response){
		//Model 선정
		request.setAttribute("boardlist", "게시판 컬렉션");
		
		//View 선정
		return "boardlist.jsp";
	}
}
