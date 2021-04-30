package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	
	private PrintWriter writer;
	
	
	@Override
	public void destroy() {
		System.out.println("LogFilter Down");
		
		writer.close();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LogFilter Start Up");
		String filename = filterConfig.getInitParameter("filename");
		if(filename == null)throw new ServletException("�α� ������ �̸��� ã�� �� ����");
		
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		}catch(IOException e) {
			throw new ServletException("�α� ������ �� �� ����");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		
		String clientIP = request.getRemoteAddr();
		String url = getURLPath(request);
		String startTime = getCurrentTime();
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		
		String endTime = getCurrentTime();
		long duration = end - start;
		
		System.out.println("Ŭ���̾�Ʈ IP : " + clientIP);
		System.out.println("URL : " + url);
		System.out.println("��û ó�� ���� : " + startTime);
		System.out.println("��û ó�� �Ϸ� : " + endTime );
		System.out.println("��û ó�� �ҿ� �ð� : " + duration + "ms");
		System.out.println("========== ========== ==========");
		
		writer.println("Ŭ���̾�Ʈ IP : " + clientIP);
		writer.println("URL : " + url);
		writer.println("��û ó�� ���� : " + startTime);
		writer.println("��û ó�� �Ϸ� : " + endTime);
		writer.println("��û ó�� �ҿ� �ð� : " + duration + "ms");
		writer.println("========== ========== ==========");
	}
	
	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currentPath = "";
		String queryString = "";
		
		if(request instanceof HttpServletRequest) {
			req = (HttpServletRequest) request;
			currentPath = req.getRequestURI();
			queryString = req.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
		} // end if
		
		return currentPath + queryString;
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
