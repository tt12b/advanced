package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceCallBack;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logTrace.LogTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    @Autowired
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);  //해당 방식이 테스트 시 더 용이하지만, TraceTemplate 자체를 스프링 Bean으로 등록해도 상관 없다.
    }

    @GetMapping("/v5/request")
    public String request(@RequestParam("itemId") String itemId) {
        return template.excute("OrderController.request()", new TraceCallBack<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
