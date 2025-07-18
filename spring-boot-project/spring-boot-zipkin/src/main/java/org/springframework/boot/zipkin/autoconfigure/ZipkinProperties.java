/*
 * Copyright 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.zipkin.autoconfigure;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for {@link ZipkinAutoConfiguration}.
 *
 * @author Moritz Halbritter
 * @since 4.0.0
 */
@ConfigurationProperties("management.zipkin.tracing")
public class ZipkinProperties {

	/**
	 * URL to the Zipkin API.
	 */
	private String endpoint = "http://localhost:9411/api/v2/spans";

	/**
	 * How to encode the POST body to the Zipkin API.
	 */
	private Encoding encoding = Encoding.JSON;

	/**
	 * Connection timeout for requests to Zipkin.
	 */
	private Duration connectTimeout = Duration.ofSeconds(1);

	/**
	 * Read timeout for requests to Zipkin.
	 */
	private Duration readTimeout = Duration.ofSeconds(10);

	public String getEndpoint() {
		return this.endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public Encoding getEncoding() {
		return this.encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

	public Duration getConnectTimeout() {
		return this.connectTimeout;
	}

	public void setConnectTimeout(Duration connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public Duration getReadTimeout() {
		return this.readTimeout;
	}

	public void setReadTimeout(Duration readTimeout) {
		this.readTimeout = readTimeout;
	}

	/**
	 * Zipkin message encoding.
	 */
	public enum Encoding {

		/**
		 * JSON.
		 */
		JSON,

		/**
		 * Protocol Buffers v3.
		 */
		PROTO3

	}

}
