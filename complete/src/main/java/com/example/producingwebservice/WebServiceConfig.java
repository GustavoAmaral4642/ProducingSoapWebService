package com.example.producingwebservice;

import org.aopalliance.intercept.Interceptor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/nokia-omc/*","/huawei-omc/*", "/ws/*" );
	}

	@Bean(name = "countries")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}

	@Bean(name = "nokia-omc")
	public DefaultWsdl11Definition defaultWsdl11DefinitionNokia(XsdSchema nokiasSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("NokiasPort");
		wsdl11Definition.setLocationUri("/nokia-omc");
		wsdl11Definition.setTargetNamespace("uri://alcatel.com/apc/9.7");
		wsdl11Definition.setSchema(nokiasSchema);
		return wsdl11Definition;
	}

	@Bean(name = "huawei-omc")
	public DefaultWsdl11Definition defaultWsdl11DefinitionHuawei(XsdSchema huaweisSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("HuaweiPort");
		wsdl11Definition.setLocationUri("/huawei-omc");
		wsdl11Definition.setTargetNamespace("os.xsd.v1");
		wsdl11Definition.setSchema(huaweisSchema);
		return wsdl11Definition;
	}

	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor security = new Wss4jSecurityInterceptor();
		security.setValidationActions("NoSecurity");
		security.setValidateRequest(false);
		security.setValidateResponse(true);
		return security;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}

	@Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
	}


	@Bean
	public XsdSchema nokiasSchema() {
		return new SimpleXsdSchema(new ClassPathResource("nokia.xsd"));
	}

	@Bean
	public XsdSchema huaweisSchema() {
		return new SimpleXsdSchema(new ClassPathResource("huawei.xsd"));
	}
}
