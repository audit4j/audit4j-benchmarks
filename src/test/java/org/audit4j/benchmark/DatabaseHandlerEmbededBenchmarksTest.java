package org.audit4j.benchmark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.audit4j.core.AuditManager;
import org.audit4j.core.Configuration;
import org.audit4j.core.DummyMetaData;
import org.audit4j.core.dto.EventBuilder;
import org.audit4j.core.handler.Handler;
import org.audit4j.core.layout.SimpleLayout;
import org.audit4j.handler.db.DatabaseAuditHandler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

	@Before
	public void setUp() throws Exception {
        /*Configuration conf = new Configuration();
        List<Handler> handlers = new ArrayList<Handler>();
        DatabaseAuditHandler handler = new DatabaseAuditHandler();
        handlers.add(handler);
        conf.setHandlers(handlers);
        conf.setLayout(new SimpleLayout());
        conf.setMetaData(new DummyMetaData());
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("log.file.location", "C:\\tmp");
        conf.setProperties(properties);
        AuditManager manager = (AuditManager) AuditManager.getConfigurationInstance(conf);
        manager.audit(new EventBuilder().addActor("Init Actor").addAction("Init").addField("Init Param", "Init")
                .build());
*/
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSendEvents() {
		bench.sendEvents();
				
	}

}
