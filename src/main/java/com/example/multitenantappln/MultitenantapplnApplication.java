package com.example.multitenantappln;
import com.example.multitenantappln.datasource.CustomRoutingDataSource;
import com.example.multitenantappln.service.MasterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.example.multitenantappln")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.multitenantappln")
public class MultitenantapplnApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MultitenantapplnApplication.class, args);            // it wil start application
	}
	@Bean
	public DataSource dataSource(){
		CustomRoutingDataSource customDataSource=new CustomRoutingDataSource();
		customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
		return customDataSource;
	}
}