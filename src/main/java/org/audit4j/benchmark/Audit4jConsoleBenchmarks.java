/*
 * Copyright (c) 2014 Janith Bandara. All Rights Reserved. 
 * This source is a part of Audit4j - An open source auditing framework.
 * http://audit4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.audit4j.benchmark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.audit4j.core.AuditManager;
import org.audit4j.core.Configuration;
import org.audit4j.core.DummyMetaData;
import org.audit4j.core.dto.AuditEvent;
import org.audit4j.core.dto.EventBuilder;
import org.audit4j.core.handler.ConsoleAuditHandler;
import org.audit4j.core.handler.Handler;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.audit4j.core.layout.SimpleLayout;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 5, time = 1)
@Fork(3) 
@State(Scope.Thread)
public class Audit4jConsoleBenchmarks {
	

	public Configuration getConfiguration() {
        Configuration conf = new Configuration();
        List<Handler> handlers = new ArrayList<Handler>();
        handlers.add(new ConsoleAuditHandler());
        conf.setHandlers(handlers);
        conf.setLayout(new SimpleLayout());
        conf.setMetaData(new DummyMetaData());
        
		return conf;
	}

    @Setup(Level.Trial)
    public void setup() {
    	

        AuditManager.startWithConfiguration(getConfiguration());
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sendEvents() {
        AuditManager.getInstance().audit(
                new EventBuilder().addActor("Init Actor").addAction("myMethod").addField("myParam1Name", "sfd")
                        .addField("myParam2Name", "sdfdsf").build());

    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void sendEventsAvgTime() {
        AuditManager.getInstance().audit(
                new EventBuilder().addActor("Init Actor").addAction("myMethod").addField("myParam1Name", "sfd")
                        .addField("myParam2Name", "sdfdsf").build());

    }
    
    @TearDown(Level.Trial)
    public void tearDown() {
    	AuditManager.shutdown();
    }
    
    
}
