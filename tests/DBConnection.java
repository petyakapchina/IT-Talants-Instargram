
import org.junit.Test;
import DAOs.ProfileDAO;
import exceptions.DataBaseProblemException;
import instagram.Profile;

public class DBConnection {

	@Test
	public void test() {
		ProfileDAO profile = new ProfileDAO();
		try {
			profile.addProfile(new Profile("Peyo", "Angelov", "PeCan", "pepi@abv.bg", "12345678900"));
		} catch (DataBaseProblemException e) {
			e.printStackTrace();
		}
		
	}

}
