package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import sun.awt.EmbeddedFrame;

public class EncodingFilter implements Filter {
	ServletContext context;
	String encoding;
	//실행중인 프로젝트(=컨테스트정보) 얻기
	//encoding 설정값 얻기
	public void init(FilterConfig fConfig) throws ServletException {
		//test프로젝트 web.xml 설정값 이용
		context = fConfig.getServletContext();
		//utf-8
		encoding = fConfig.getInitParameter("encoding");
	}
	//"/" : 모든 요청
	//servlet의 service와 같은 역할
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청 있을 때마다 클라이언트 ip 출력하기
		String clientIP = ((HttpServletRequest)request).getRemoteAddr();
		context.log("***" + clientIP + " 로부터 요청이 전달되었습니다***");
		
		//요청 있을 때마다 설정된 인코딩 적용하기
		request.setCharacterEncoding(encoding);
		//다른 Filter 구현 클래스 있으면 연결하기
		chain.doFilter(request, response);
	}

	public void destroy() {}
}
