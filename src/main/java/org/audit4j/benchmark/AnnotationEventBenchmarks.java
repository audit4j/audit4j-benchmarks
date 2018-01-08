package org.audit4j.benchmark;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.audit4j.benchmark.mock.MethodAnnotationMock;
import org.audit4j.core.AuditManager;
import org.audit4j.core.Configuration;
import org.audit4j.core.DummyMetaData;
import org.audit4j.core.dto.AnnotationAuditEvent;
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
public class AnnotationEventBenchmarks extends BenchmarkBase {

    private AnnotationAuditEvent event = null;

    private AnnotationAuditEvent m_a_s_all_event = null;

    private AnnotationAuditEvent m_a_s_marked_event = null;

    @Setup(Level.Trial)
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
        AuditManager.startWithConfiguration(conf);
        event = getSampleAnnotationEvent();
        m_a_s_all_event = generateMethodAnnotationSelectionAllEvent();
        m_a_s_marked_event = generateMethodAnnotationSelectionMarkedEvent();
    }

    @TearDown(Level.Trial)
    public void tearDown() {
    	AuditManager.shutdown();
    }
    
    
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sendClassAnnotationEvents() {
        AuditManager.getInstance().audit(event);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void sendClassAnnotationEvents_Runningtime() {
        AuditManager.getInstance().audit(event);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sendMethodAnnotationEvents_Selection_All() {
        AuditManager.getInstance().audit(m_a_s_all_event);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sendMethodAnnotationEvents_Selection_Marked() {
        AuditManager.getInstance().audit(m_a_s_marked_event);
    }

    private AnnotationAuditEvent generateMethodAnnotationSelectionAllEvent() {
        Method annoMethod = null;
        try {
            annoMethod = MethodAnnotationMock.class.getMethod("testAnnotation_selection_all", Integer.class,
                    String.class, MethodAnnotationMock.class, Object.class, String.class);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        System.out.println(annoMethod);
        Object[] args = new Object[5];
        args[0] = 1;
        args[1] = "1";
        args[2] = new MethodAnnotationMock();
        args[3] = new Object();
        args[4] = "1";
        return new AnnotationAuditEvent(MethodAnnotationMock.class, annoMethod, args);
    }

    private AnnotationAuditEvent generateMethodAnnotationSelectionMarkedEvent() {
        Method annoMethod = null;
        try {
            annoMethod = MethodAnnotationMock.class.getMethod("testAnnotation_selection_marked", Integer.class,
                    String.class, MethodAnnotationMock.class, Object.class, String.class);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        System.out.println(annoMethod);
        Object[] args = new Object[5];
        args[0] = 1;
        args[1] = "1";
        args[2] = new MethodAnnotationMock();
        args[3] = new Object();
        args[4] = "1";

        return new AnnotationAuditEvent(MethodAnnotationMock.class, annoMethod, args);
    }
}
