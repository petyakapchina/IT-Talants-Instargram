package DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import instagram.DBConnection;

public class SearchDAO {

	private Connection conn = DBConnection.getInstance().getConnection();

	public boolean getResult(String searchBy) {
		boolean status = false;
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT * FROM users");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("username");
				if (username.equals(searchBy)) {
					System.out.println("Correct.");
					status = true;
					break;
				} else {
					status = false;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
