package org.audit4j.benchmark;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DatabaseHandlerEmbededBenchmarksTest {
	
	private static DatabaseHandlerEmbededBenchmarks bench;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bench = new DatabaseHandlerEmbededBenchmarks();
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
