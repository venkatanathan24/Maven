package org.test;

import org.testng.annotations.Test;

public class TestDemo {
	
	@Test(priority=1)
	private void tc(){
		System.out.println("Test Case");
	}

	@Test(priority=-100)
	private void tc3() {
		System.out.println("Test Case 3");
	}
	
	@Test(priority=-10)
	private void tc2() {
		System.out.println("Test Case 2");
	}
	
}
