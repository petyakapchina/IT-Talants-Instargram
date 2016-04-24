package DAOs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Photo;

public class PhotoDAO implements IPhoto {

	private FileInputStream input = null;
	private Connection conn = DBConnection.getInstance().getConnection();

	public void addPhoto(Photo p, String url) throws DataBaseProblemException {
		if (p != null) {
			try {
				String sql = "INSERT INTO photos VALUES (null,?,?,?,?,?);";
				PreparedStatement pstat = conn.prepareStatement(sql);
				java.io.File theFile = new File(url);
				input = new FileInputStream(theFile);
				pstat.setBinaryStream(1, input);
				pstat.setString(2, p.getHashTag());
				pstat.setInt(3, 0);
				pstat.setString(4, p.getOwner().getUserName());
				pstat.setDate(5, (java.sql.Date) new Date());
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add an profile", e);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Empty file", e);
			}
		}
	}

	public void removePhoto(Photo p) throws DataBaseProblemException {
		if (p != null) {
			try {
				PreparedStatement ps = conn.prepareStatement("DELETE FROM photos WHERE photo_id=?");
				ps.setString(1, p.);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't delete an this picture...",e);
			}
		}
	}

	public Photo getPhotoByHashTag(String hashTag) throws DataBaseProblemException {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM photos WHERE tag=?");
			ps.setString(1, hashTag);
			ResultSet result = ps.executeQuery();
			result.next();
			return new Photo(hashTag);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseProblemException("Can't find an photo with tag : " + hashTag, e);
		}
	}

}
