package org.audit4j.benchmark;

import java.lang.reflect.Method;

import org.audit4j.benchmark.Mock.ClassAnnotationMock;
import org.audit4j.benchmark.Mock.NullAnnotationMock;
import org.audit4j.core.Configuration;
import org.audit4j.core.DummyMetaData;
import org.audit4j.core.dto.AnnotationAuditEvent;
import org.audit4j.core.dto.AuditEvent;
import org.audit4j.core.dto.EventBuilder;
import org.audit4j.core.handler.ConsoleAuditHandler;
import org.audit4j.core.layout.SimpleLayout;

public class BenchmarkBase {
    protected AuditEvent getSampleAuditEvent() {
        String actor = "Dummy Actor";
        EventBuilder builder = new EventBuilder();
        builder.addActor(actor).addAction("myMethod").addOrigin("Origin").addField("myParam1Name", "param1")
                .addField("myParam2Name", new Integer(2));
        AuditEvent event = builder.build();
        return event;
    }

    protected Configuration getDefaultConfiguration() {
        Configuration config = new Configuration();
        config.addHandler(new ConsoleAuditHandler());
        config.setLayout(new SimpleLayout());
        config.setMetaData(new DummyMetaData());
        return config;
    }
    
    protected AnnotationAuditEvent getSampleAnnotationEvent() {
        Method annoMethod = null;
        try {
            annoMethod = ClassAnnotationMock.class.getMethod("testClassAnnotation_selection_all", String.class);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Object[] args = new Object[1];
        args[0] = "123232323";
        return new AnnotationAuditEvent(ClassAnnotationMock.class, annoMethod, args);
    }

    protected AnnotationAuditEvent getSampleNullAnnotationEvent() {
        Method annoMethod = null;
        try {
            annoMethod = NullAnnotationMock.class.getMethod("testNullAnnotation_Method", String.class);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Object[] args = new Object[1];
        args[0] = "123232323";
        return new AnnotationAuditEvent(NullAnnotationMock.class, annoMethod, args);
    }

}
