package data;

import java.util.Random;

public class TestData {
	
	public String generateRandomUser() {
		Random random = new Random();
		int number = random.nextInt(2000);
		return "sharuq"+number;
	}
	
	public String generateRandomPassword() {
		Random random = new Random();
		int number = random.nextInt(2000);
		return "lover"+number;
	}

}
