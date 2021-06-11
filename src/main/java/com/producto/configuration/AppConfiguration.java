package com.producto.configuration;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfiguration {
	
	@Autowired
	DataSource dataSource;
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	@Primary
	public void startConnection() {
		try {
			Socket socket = new Socket("localhost", 9090);
			DataSourceBuilder<DataSource> dataSourceBuilder = (DataSourceBuilder<DataSource>) DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("org.h2.Driver");
	        dataSourceBuilder.url("jdbc:h2:tcp://localhost:9090/mem:sinsajodb");
	        dataSourceBuilder.username("sa");
	        dataSourceBuilder.password("");
	        dataSource = dataSourceBuilder.build();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DataSourceBuilder<DataSource> dataSourceBuilder = (DataSourceBuilder<DataSource>) DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("org.h2.Driver");
	        dataSourceBuilder.url("jdbc:h2:mem:productodb");
	        dataSourceBuilder.username("sa");
	        dataSourceBuilder.password("");
			dataSource = dataSourceBuilder.build();
		}
		
	}

}
