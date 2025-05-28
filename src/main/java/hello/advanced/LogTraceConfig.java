package hello.advanced;

import hello.advanced.trace.logTrace.FieldLogTrace;
import hello.advanced.trace.logTrace.LogTrace;
import hello.advanced.trace.logTrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

//    @Bean
//    @Primary
//    public LogTrace logTrace() {
//        return new FieldLogTrace();
//    }
//
//    @Bean(name ="threadLocalLogTrace")
//    public LogTrace ThreadLocalLogTrace() {
//        return new ThreadLocalLogTrace();
//    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
