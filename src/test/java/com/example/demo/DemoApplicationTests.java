package com.example.demo;

import com.example.demo.model.Credit;
import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;
import com.example.demo.service.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private static PaymentServiceImpl paymentService;
	@Test

//	public Credit(String title, String currency, Boolean isPaid, BigDecimal amount, Timestamp timestamp) {

	public void contextLoads() {
//		paymentService.validatePayment(new Payment("Hello, test",12030, LocalDateTime.now(), new Credit("Hello, test","RUB",false, BigDecimal.valueOf(10000.0),LocalDateTime.now())))
	}

}
