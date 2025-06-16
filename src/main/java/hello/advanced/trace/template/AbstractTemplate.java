package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.LogTrace;

/**
 * packageName    : hello.advanced.trace.template
 * fileName       : AbstractTemplate
 * author         : MYH
 * date           : 2025-05-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-05-29        MYH       최초 생성
 */
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace){

        this.trace = trace;
    }

    public T excute(String message) {
        TraceStatus status = null;
        try {
             status = trace.begin(message);
             //로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e){
            trace.exception(status,e);
            throw e;
        }


    }

    protected abstract T call();
}
