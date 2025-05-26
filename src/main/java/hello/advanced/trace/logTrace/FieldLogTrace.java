package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceStatus;

public class FieldLogTrace implements LogTrace{

    @Override
    public TraceStatus begin(String message) {
        return null;
    }
    @Override
    public void end(TraceStatus traceStatus) {

    }

    @Override
    public void exception(TraceStatus traceStatus, Exception e) {

    }
}
