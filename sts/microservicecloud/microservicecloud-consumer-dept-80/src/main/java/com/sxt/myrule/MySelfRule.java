package com.sxt.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
		return new RoundRobinRule();
	}
}
