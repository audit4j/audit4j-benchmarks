package org.audit4j.benchmark;

import java.util.concurrent.TimeUnit;

import org.audit4j.core.AuditManager;
import org.audit4j.core.dto.EventBuilder;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 5, time = 1)
@Fork(3) 
@State(Scope.Thread)
public class Slf4jBenchmarks {
	
	private static final Logger logger = LoggerFactory.getLogger(Slf4jBenchmarks.class);

    

    
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void slf4j() {
    	logger.info("Init Actor, action=myMethod, fields={myParam1Name=sfd,myParam2Name=sdfdsf}");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void sslf4jAvgTime() {
    	logger.info("Init Actor, action=myMethod, fields={myParam1Name=sfd,myParam2Name=sdfdsf}");
    }
}
