package com.example.producingwebservice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import v1.xsd.os.BINDResponse;

import java.util.HashMap;
import java.util.Map;

@Component
public class HuaweiRepository {
	private static final Map<String, BINDResponse> binds = new HashMap<>();

	@PostConstruct
	public void initData() {
		BINDResponse bind = new BINDResponse();
		bind.setDateTime("2023-06-29 22:46:37");
		bind.setErrCode("0");
		bind.setErrDesc("Succeeded");
		bind.setSession("kotlin@2dbab7c4-ddbb-4401-abcb-b34e6873deab</");
		bind.setDID(" ");

		binds.put("register", bind);
	}

	public BINDResponse findHuawei(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return binds.get(name);
	}
}
