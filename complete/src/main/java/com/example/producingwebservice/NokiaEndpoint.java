package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import uri.alcatel_com.apc._9.GetNokiaRequest;
import uri.alcatel_com.apc._9.ModifyResponse;

@Endpoint
public class NokiaEndpoint {
	private static final String NAMESPACE_URI = "uri://alcatel.com/apc/9.7";

	private NokiaRepository nokiaRepository;

	@Autowired
	public NokiaEndpoint(NokiaRepository nokiaRepository) {
		this.nokiaRepository = nokiaRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNokiaRequest")
	@ResponsePayload
	public ModifyResponse getCountry(@RequestPayload GetNokiaRequest request) {

		ModifyResponse response = new ModifyResponse();

		return response;
	}
}
