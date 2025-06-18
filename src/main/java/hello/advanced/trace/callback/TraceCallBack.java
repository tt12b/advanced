package hello.advanced.trace.callback;

/**
 * packageName    : hello.advanced.trace.callback
 * fileName       : TraceCallBack
 * author         : MYH
 * date           : 2025-06-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-06-18        MYH       최초 생성
 */
public interface TraceCallBack<T> {
    T call();
}
