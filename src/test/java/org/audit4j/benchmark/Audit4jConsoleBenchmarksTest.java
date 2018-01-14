package org.audit4j.benchmark;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Audit4jConsoleBenchmarksTest {
	
	private static Audit4jConsoleBenchmarks bench;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bench = new Audit4jConsoleBenchmarks();
		bench.setup();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bench.tearDown();
	}



	@Test
	public void testSendEvents() {
		bench.sendEvents();
	}

}
