package SQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class connect
 */
@WebServlet("/connect1")
public class connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public static class Connect {

		private static final String SQLSERVER_IP = "192.168.2.103";
		private static final String SQLSERVER_PORT = "1433";
		private static final String SQLSERVER_DB_NAME = "test"; // Database名
		private static final String SQLSERVER_USER = "sa";
		private static final String SQLSERVER_PASSWORD = "a";

		public static String select(String sentId) {

			Connection con;
			String pass = null;
			// DB Connect
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

				con = DriverManager.getConnection(getConnectionString());

				Statement stmt = con.createStatement();

				// SQL
				String SQL = "SELECT password FROM usermaster where userid = '" + sentId + "'"; // SQL文
				// execute
				ResultSet rs = stmt.executeQuery(SQL);
				while (rs.next()) {
					pass = rs.getString("password");
				}

			}
			// Handle any errors that may have occurred.
			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sentId = pass;
			System.out.println("------------------------");
			System.out.println(pass + "sqlで参照したパスワード");
			System.out.println("------------------------");
			return pass;

		}
		
		/**
		 * 接続文字列を生成
		 * 
		 * @return
		 */
		private static String getConnectionString() {
			return "jdbc:sqlserver://" + SQLSERVER_IP + ":" + SQLSERVER_PORT + ";" + "databaseName=" + SQLSERVER_DB_NAME
					+ ";" + "user=" + SQLSERVER_USER + ";" + "password=" + SQLSERVER_PASSWORD;
		}
	}

}
