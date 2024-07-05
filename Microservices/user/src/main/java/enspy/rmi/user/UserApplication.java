package enspy.rmi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.pulsar.annotation.EnablePulsar;

@EnableCassandraRepositories(basePackages = "enspy.rmi.user.repository")
@EnablePulsar
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
