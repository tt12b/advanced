package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.CallBack;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * packageName    : hello.advanced.trace.strategy
 * fileName       : TemplateCallBackTest
 * author         : MYH
 * date           : 2025-06-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-06-18        MYH       최초 생성
 */
@Slf4j
public class TemplateCallBackTest {

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callBackV1(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });

        template.excute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람다
     */
    @Test
    void callBackV2(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(()-> log.info("비즈니스 로직 1 실행"));
        template.excute(()-> log.info("비즈니스 로직 2 실행"));
    }
}
