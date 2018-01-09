audit4j-benchmarks
==================

[![Build Status](https://travis-ci.org/audit4j/audit4j-benchmarks.svg?branch=master)](https://travis-ci.org/audit4j/audit4j-benchmarks)

This benchmark is using jmh framework
To reproduce this benchmark
use first mvn clean package
then use
java -jar target\microbenchmarks.jar

# results
Microbench with pc on Windows 10

With Processeur	Intel(R) Core(TM) i3-3217U CPU @ 1.80GHz, 1801�MHz, 2 c�ur(s), 4 processeur(s) logique(s)

| Benchmark                                                             | Mode  Cnt     Score      Error  Units  |
| --------------------------------------------------------------------- | -------------------------------------- |
| AnnotationEventBenchmarks.sendClassAnnotationEvents                   | thrpt   15  2608,569 ± 1143,076  ops/s |
| AnnotationEventBenchmarks.sendMethodAnnotationEvents_Selection_All    | thrpt   15  3278,225 ±  232,428  ops/s |
| AnnotationEventBenchmarks.sendMethodAnnotationEvents_Selection_Marked | thrpt   15  2695,198 ±  294,375  ops/s |
| Audit4jConsoleBenchmarks.sendEvents                                   | thrpt   15  5864,947 ±  974,146  ops/s |
| Audit4jFileBenchmarks.sendEvents                                      | thrpt   15  3483,119 ±  324,000  ops/s |
| Slf4jBenchmarks.slf4j                                                 | thrpt   15  6178,890 ± 1169,859  ops/s |
| AnnotationEventBenchmarks.sendClassAnnotationEvents_Runningtime       | avgt   15   322,272 ±  114,318  us/op  |
| Audit4jConsoleBenchmarks.sendEventsAvgTime                            | avgt   15   179,970 ±   20,152  us/op  |
| Audit4jFileBenchmarks.sendEventsAvgTime                               | avgt   15   290,120 ±   17,309  us/op  |
| Slf4jBenchmarks.sslf4jAvgTime                                         | avgt   15   184,155 ±   35,477  us/op  |

