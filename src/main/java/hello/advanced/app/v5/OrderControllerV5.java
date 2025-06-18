package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logTrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final LogTrace trace;

    @GetMapping("/v5/request")
    public String request(@RequestParam("itemId") String itemId) {
       TraceTemplate traceTemplate = new TraceTemplate(trace);

        return traceTemplate.excute("OrderController.request()", ()->"로직 1 실행");
    }
}
