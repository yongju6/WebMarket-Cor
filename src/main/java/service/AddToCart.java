package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Product;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/cart/add")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����ڰ� ��ٱ��Ͽ� �߰��� ��ǰ ��ȣ�� �����ϸ�
		// �ش� ��ȣ�� �����Ѵ�.
		
		// ������� ��ٱ��� ������ ���� �ִ� ������ �����´�.
		HttpSession session = request.getSession();
		
		
		
//		// ������ ������ �ð��� ��ȯ
//		System.out.println(session.getCreationTime());
//		// ������ ID�� ��ȯ
//		System.out.println(session.getId());
//		// ������ ���� ����(ó�� ������ �����̸� true, ������ ������ �����̸� false ��ȯ)
//		System.out.println(session.isNew());
		// ���ǿ��� ��ٱ���(goodsList)�� ������.		
		ArrayList<String> goodsList = (ArrayList<String>) session.getAttribute("goodsList");
		
		if(goodsList == null) {
			goodsList = new ArrayList<String>();
		}
		
		String productId = request.getParameter("productId");
		goodsList.add(productId);
		
		session.setAttribute("goodsList", goodsList);
		
		response.setStatus(204);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
