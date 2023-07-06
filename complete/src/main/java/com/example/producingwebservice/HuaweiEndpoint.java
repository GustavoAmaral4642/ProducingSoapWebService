package com.example.producingwebservice;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;
import v1.xsd.os.BINDONTDBAPROF;
import v1.xsd.os.BINDResponse;

@Endpoint
public class HuaweiEndpoint {
	private static final String NAMESPACE_URI = "os.xsd.v1";

	private HuaweiRepository huaweiRepository;

	@Autowired
	public HuaweiEndpoint(HuaweiRepository huaweiRepository) {
		this.huaweiRepository = huaweiRepository;
	}

	private Security unmarshallSecurityFromSoapHeader(SoapHeaderElement header) {
		Security security = null;
		try {

			JAXBContext context = JAXBContext.newInstance(Security.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			security = (Security) unmarshaller.unmarshal(header.getSource());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return security;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BIND-ONTDBAPROF")
	@ResponsePayload
	public BINDResponse getHuawei(@RequestPayload BINDONTDBAPROF request, @SoapHeader(value = "{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}Security") SoapHeaderElement wsseSecurityHeader) throws JAXBException {

		Security security = unmarshallSecurityFromSoapHeader(wsseSecurityHeader);

		BINDResponse response = new BINDResponse();
		response.setDateTime("2023-06-29 22:46:37");
		response.setErrCode("0");
		response.setErrDesc("Succeeded");
		response.setSession("kotlin@2dbab7c4-ddbb-4401-abcb-b34e6873deab");
		response.setDID("");

		return response;
	}
}
