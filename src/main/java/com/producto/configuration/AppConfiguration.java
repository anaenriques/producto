package com.producto.configuration;

import java.io.IOException;
import java.net.Socket;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	@Bean
	public DataSource startConnection() {
		
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
		
		if(isPortInUse("localhost", 9090))
	        dataSourceBuilder.url("jdbc:h2:tcp://localhost:9090/mem:sinsajodb");
		else
	        dataSourceBuilder.url("jdbc:h2:mem:productodb");
		
		return dataSourceBuilder.build();
		
	}
	
	private boolean isPortInUse(String hostName, int portNumber) {
		boolean result = false;
		
		try {
			Socket socket = new Socket("localhost", 9090);
			socket.close();
			result = true;
		} catch(IOException e) {
			result = false;
		}
		
		return result;
	}

}
