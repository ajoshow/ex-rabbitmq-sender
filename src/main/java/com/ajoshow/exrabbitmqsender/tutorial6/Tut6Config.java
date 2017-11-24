package com.ajoshow.exrabbitmqsender.tutorial6;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({ "tut6", "rpc" })
@Configuration
public class Tut6Config {

	private static class ClientConfig {

		@Bean
		public DirectExchange exchange() {
			return new DirectExchange("tut.rpc");
		}

		@Bean
		public Tut6Client client() {
			return new Tut6Client();
		}

	}
}
