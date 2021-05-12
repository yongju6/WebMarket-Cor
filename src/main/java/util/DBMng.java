package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMng {
	private static Connection conn = null;
	
	private DBMng() {
		// �̱��� ������ ����Ǵ� Ŭ����
		
	}
	
	/**
	 * DBMS Ŀ�ؼ��� ��ȯ�ϴ� �޼���
	 * 
	 * @return java.sql.Connection
	 * @throws SQLException : DBMS�� ������ ������ ��
	 */
	public static Connection getConnection() throws SQLException{
		if(conn == null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/webmarketdb?user=root&password=koreait");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			} // end try-catch
		} // end if
		return conn;
	}
	
	public static void closeConnection() {
		if(conn!= null) {
			try {
				conn.close();
				
				conn = null;
			} catch(SQLException e) {
				e.printStackTrace();
			} // end try-catch
		} // end if
	}
}
