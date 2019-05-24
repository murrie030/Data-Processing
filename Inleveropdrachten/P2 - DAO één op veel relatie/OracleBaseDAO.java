package p2DAO;

import java.sql.*;

public class OracleBaseDAO {
	private Connection myConn = null;

	protected Connection getConnection() {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username = "OVCHIP";
		String password = "OVCHIP";

		if (myConn == null) {
			try {
				myConn = DriverManager.getConnection(url, username, password);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		
		return myConn;
	}

	public void closeConnection() {
		try {
			myConn.close();
			myConn = null;
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
