package org.unit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Sample {
	@Ignore
	@Test
	public void tc412() {
		System.out.println("Test Case 32");
	}

	@Test
	public void tc2() {
		System.out.println("Test Case 2");
	}

	@Test
	public void tc3() {
		System.out.println("Test Case 3");
	}

	@Before
	public void BeforeMethod() {
		System.out.println("Before");
	}

	@BeforeClass
	public static void BeforeClassMethod() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void AfterClassMethod() {
		System.out.println("AfterClass");
	}

	@After
	public void AfterMethod() {
		System.out.println("After");	
	}
}
