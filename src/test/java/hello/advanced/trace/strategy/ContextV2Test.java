package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * packageName    : hello.advanced.trace.strategy.code
 * fileName       : ContextV2Test
 * author         : MYH
 * date           : 2025-06-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-06-17        MYH       최초 생성
 */

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.excute(new StrategyLogic1());
        context.excute(new StrategyLogic1());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.excute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        context.excute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스2 , 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.excute(() -> log.info("비즈니스 로직 1실행"));
        context.excute(()-> log.info("비즈니스 로직 2실행"));
    }
}
