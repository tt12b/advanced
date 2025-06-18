package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.LogTrace;

/**
 * packageName    : hello.advanced.trace.callback
 * fileName       : TraceTemplate
 * author         : MYH
 * date           : 2025-06-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-06-18        MYH       최초 생성
 */
public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T excute(String message, TraceCallBack<T> callBack){
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            //로직 호출
            T result = callBack.call();

            trace.end(status);
            return result;
        } catch (Exception e){
            trace.exception(status,e);
            throw e;
        }

    }
}
