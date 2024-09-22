package com.pp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pp.demo.common.Payment;
import com.pp.demo.common.TransactionRequest;
import com.pp.demo.common.TransactionResponse;
import com.pp.demo.entity.Order;
import com.pp.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//Rest call
		
	    Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		
		repository.save(order);
		response =  paymentResponse.getPaymentStatus().equals("success")?"Payment processing successfull and order placed":"There is failure in payment api, order added to cart.";
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
	}

}
