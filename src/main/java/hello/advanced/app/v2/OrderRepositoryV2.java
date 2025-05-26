package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId,String itemId){

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderRepository.save()");

            if("ex".equals(itemId)){
                throw new IllegalStateException("예외 발생");
            }
            trace.end(status);
        } catch (Exception e){
            trace.exception(status,e);
            throw e;
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
