package DAOs;

import java.sql.*;

import instagram.DBConnection;

public class LoginDao {

	private Connection conn = DBConnection.getInstance().getConnection();

	public boolean validate(String name, String pass) {
		boolean status = false;
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT * FROM users");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				if (username.equals(name) && pass.equals(password)) {
					System.out.println("Correct user.");
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
