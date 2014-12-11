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
import org.audit4j.core.SimpleLayout;
import org.audit4j.core.dto.EventBuilder;
import org.audit4j.core.handler.Handler;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(iterations = 5, time = 5)
@Warmup(iterations = 5)
@Fork(1)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
public class GeneralBenchmarks {

    @Setup
    public void setup() {
        Configuration conf = new Configuration();
        List<Handler> handlers = new ArrayList<Handler>();
        handlers.add(new FileAuditHandler());
        conf.setHandlers(handlers);
        conf.setLayout(new SimpleLayout());
        conf.setMetaData(new DummyMetaData());
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("log.file.location", "C:\\tmp");
        conf.setProperties(properties);
        AuditManager manager = AuditManager.getConfigurationInstance(conf);
        manager.audit(new EventBuilder().addActor("Init Actor").addAction("Init").addField("Init Param", "Init")
                .build());
    }

    @Benchmark
    public void sendEvents() {
        AuditManager.getInstance().audit(
                new EventBuilder().addActor("Init Actor").addAction("myMethod").addField("myParam1Name", "sfd")
                        .addField("myParam2Name", "sdfdsf").build());

    }

    @TearDown
    public void tearDown() {

    }
}