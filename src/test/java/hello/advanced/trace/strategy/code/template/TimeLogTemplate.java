package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : hello.advanced.trace.strategy.code.template
 * fileName       : TimeLogTemplate
 * author         : MYH
 * date           : 2025-06-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-06-18        MYH       최초 생성
 */
@Slf4j
public class TimeLogTemplate {

    public void excute(CallBack callBack) {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        callBack.call(); //위임
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}