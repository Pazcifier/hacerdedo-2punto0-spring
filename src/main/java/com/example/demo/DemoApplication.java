package com.example.demo;

import com.example.demo.DB.ConnectionFactory;
import java.sql.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
            Logger log = LoggerFactory.getLogger(DemoApplication.class);
            Connection con = ConnectionFactory.getConnection();
            
            try {
                
            if (!con.isClosed()) {
                log.info("Conexión exitosa");
            }
            
            SpringApplication.run(DemoApplication.class, args);
            
            } catch (Exception e) {
                System.out.println("Exception");
            }
            
            finally {
                ConnectionFactory.closeConnection(con);
            }
	}

}
