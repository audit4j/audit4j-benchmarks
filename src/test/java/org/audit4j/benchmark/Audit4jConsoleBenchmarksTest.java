package org.audit4j.benchmark;

import static org.junit.Assert.*;

import org.audit4j.core.AuditManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
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
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSendEvents() {
		bench.sendEvents();
	}

}
