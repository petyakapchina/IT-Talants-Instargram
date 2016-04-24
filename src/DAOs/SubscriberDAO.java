package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Profile;

public class SubscriberDAO implements ISubsciber {

	private Connection conn = DBConnection.getInstance().getConnection();

	public void addSubscriber(Profile user, Profile subscriber) throws DataBaseProblemException {
		if (user != null && subscriber != null) {
			try {
				PreparedStatement pstat = conn.prepareStatement("INSERT INTO subscribers VALUES (?,?)");
				PreparedStatement ps2 = conn.prepareStatement("update users set number_of_subs="
						+ (user.getNumberOfSubscribers() + 1) + " where user_id=" + user.getId());
				pstat.setInt(1, user.getId());
				pstat.setInt(2, subscriber.getId());
				ps2.setInt(7, (user.getNumberOfSubscribers() + 1));
				ps2.executeUpdate();
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Unsuccessful. Problem occured.", e);
			}
		}
	}

	public void removeSubscriber(Profile user, Profile subscriber) throws DataBaseProblemException {
		if (user != null & subscriber != null) {
			try {
				PreparedStatement ps = conn
						.prepareStatement("DELETE FROM subscribers WHERE subscriber_id=?, user_id=?");
				PreparedStatement ps2 = conn.prepareStatement("update users set number_of_subs="
						+ (user.getNumberOfSubscribers() - 1) + " where user_id=" + user.getId());
				ps.setInt(1, subscriber.getId());
				ps.setInt(1, user.getId());
				ps2.setInt(7, (user.getNumberOfSubscribers() - 1));
				ps2.executeUpdate();
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Unsuccessful. Problem occured.", e);
			}
		}
	}

}
