package com.example.producingwebservice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import uri.alcatel_com.apc._9.Modify;

import java.util.HashMap;
import java.util.Map;

@Component
public class NokiaRepository {
	private static final Map<String, Modify> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		Modify modify = new Modify();
		modify.setObjectName("NVG_A02_GPON_VLAN_32-ALC:1-1-2-4-20");
		modify.setTemplateName("GVT_GPON");
/*
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		countries.put(spain.getName(), spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		countries.put(poland.getName(), poland);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.put(uk.getName(), uk);

		Country br = new Country();
		br.setName("Brasil");
		br.setCapital("São Paulo");
		br.setCurrency(Currency.BRL);
		br.setPopulation(70000000);

		countries.put(br.getName(), br);*/
	}

/*	public Country findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}*/
}
