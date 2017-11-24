package com.ajoshow.exrabbitmqsender.tutorial7;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut7","topics-custom"})
@Configuration
public class Tut7Config {

	@Bean
	public TopicExchange ctbcTopic() {
		return new TopicExchange("ctbc.topic");
	}

	private static class ReceiverConfig {

		@Bean
		public Tut7Sender sender() {
			return new Tut7Sender();
		}

		@Bean
		public Queue ctbcApiQueue() {
			return new Queue("ctbc.api");
		}

		@Bean
		public Queue ctbcErrorQueue() {
			return new Queue("ctbc.error");
		}

		@Bean
		public Binding binding1a(TopicExchange ctbcTopic,
						Queue ctbcApiQueue) {
			return BindingBuilder.bind(ctbcApiQueue)
								 .to(ctbcTopic)
								 .with("ctbc.api.#");
		}

		@Bean
		public Binding binding1b(TopicExchange ctbcTopic,
						Queue ctbcErrorQueue) {
			return BindingBuilder.bind(ctbcErrorQueue)
								 .to(ctbcTopic)
								 .with("ctbc.error.#");
		}

	}




}