package com.example.demo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


@RestController
class MicroMeter {
	
	private Counter counter = Metrics.counter("custom.metrics.counter");

	@GetMapping("/counter")
	public ResponseEntity<String> hello (@RequestHeader Map<String, String> header) {
		counter.increment();
		return ResponseEntity.ok("Count Complete");
	}
	
}
