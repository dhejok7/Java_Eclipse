package loan;

import org.testng.annotations.Test;

public class HomeLoan {
	@Test //(enabled = false) // to skip this test case, we provide (enabled = false)
	public void webLoginHL() {
		System.out.println("webLoginHL");
	}

	@Test
	public void mobileLoginHL() {
		System.out.println("mobileLoginHL");
	}

	@Test
	public void connectionAPISuccessHL() {
		System.out.println("connectionAPISuccessHL");
	}
}
