package com.qsp.SpringBoot_Foodapp.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.VendorExtension;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {

	
	@Bean
	public Docket getDocket(){
		Contact contact = new Contact("TestYantra", "www.testYantra.com", "testYantra@email.com");
		List<VendorExtension> vendorExtension = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("FoodApp", "food api for in house order", "1.01", "www.testyantra.com", contact,
				"1 year free service", "www.testyantra.com", vendorExtension);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.SpringBoot_Foodapp")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
		
	}
}
