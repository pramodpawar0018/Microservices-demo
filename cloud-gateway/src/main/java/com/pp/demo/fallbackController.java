//package com.pp.demo;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//@RestController
//public class fallbackController {
//
//	 @GetMapping("/orderFallBack")
//	    public Mono<String> orderServiceFallBack() {
//	        return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
//	    }
//	    @GetMapping("/paymentFallback")
//	    public Mono<String> paymentServiceFallBack() {
//	        return Mono.just("Payment Service is taking too long to respond or is down. Please try again later");
//	    }
//}
