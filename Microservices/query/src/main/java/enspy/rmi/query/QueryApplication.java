package enspy.rmi.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.pulsar.annotation.EnablePulsar;

@EnableCassandraRepositories(basePackages = "enspy.rmi.query.repository")
@EnablePulsar
@SpringBootApplication
public class QueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

}
