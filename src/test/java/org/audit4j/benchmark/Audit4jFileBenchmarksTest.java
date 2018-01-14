package org.audit4j.benchmark;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.audit4j.core.AuditManager;
import org.audit4j.core.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Audit4jFileBenchmarksTest {

	private static Audit4jFileBenchmarks bench;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bench = new Audit4jFileBenchmarks();
		Configuration conf = bench.getConfiguration();
		
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("log.file.location", ".");
        conf.setProperties(properties);
		
		AuditManager.startWithConfiguration(conf);
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
