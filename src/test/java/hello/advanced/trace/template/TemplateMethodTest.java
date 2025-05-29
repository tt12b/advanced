package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();
        //Business logic start
        log.info("Excute Business Logic1");
        //Business logic end
        long endTime = System.currentTimeMillis();
        long resultTime = endTime-startTime;
        log.info("resultTime={}",resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        //Business logic start
        log.info("Excute Business Logic2");
        //Business logic end
        long endTime = System.currentTimeMillis();
        long resultTime = endTime-startTime;
        log.info("resultTime={}",resultTime);
    }

    /**
     * Template Method Pattern
     */
    @Test
    void templateMethodV1(){
        AbstractTemplate template1 = new SubClassLogic1();
        template1.excute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.excute();
    }

    @Test
    void templateMethodV2(){
        //-----------------------------------------
        AbstractTemplate template1 = new SubClassLogic1();
        log.info("className1={}",template1.getClass()); //className1=class hello.advanced.trace.template.code.SubClassLogic1
        template1.excute();

        //-----------------------------------------
        var template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Execute Business Logic 2");
            }
        };
        log.info("className2={}",template2.getClass()); //className2=class hello.advanced.trace.template.TemplateMethodTest$1
        template2.excute();

        //-----------------------------------------
        new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Execute Business Logic 3");
            }
        }.excute();
        //-----------------------------------------
    }

}
