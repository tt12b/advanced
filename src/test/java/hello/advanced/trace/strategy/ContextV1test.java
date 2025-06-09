package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.Contextv1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1test {

    @Test
    void StrategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //Business logic start
        log.info("Excute Business Logic1");
        //Business logic end
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //Business logic start
        log.info("Excute Business Logic2");
        //Business logic end
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        Contextv1 contextv1 = new Contextv1(strategyLogic1);
        contextv1.excute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        Contextv1 contextv2 = new Contextv1(strategyLogic2);
        contextv2.excute();
    }

    /**
     * 익명 내부 클래스 사용해보기
     */
    @Test
    void strategyV2() {
        var strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("익명 클래스로 인터페이스 구현, 비즈니스 로직 1실행");
            }
        };

        Contextv1 contextv1 = new Contextv1(strategyLogic1);
        contextv1.excute();
    }

    @Test
    void strategyV3() {

        Contextv1 contextv1 = new Contextv1(new Strategy() {
            @Override
            public void call() {
                log.info("생성자에 구현체 직접 넣기, 비즈니스 로직 1실행");
            }
        });
        contextv1.excute();
    }

    @Test
    void strategyV4(){
        Contextv1 contextv1 = new Contextv1(() -> log.info("람다로 편하게"));
        contextv1.excute();
    }
}

