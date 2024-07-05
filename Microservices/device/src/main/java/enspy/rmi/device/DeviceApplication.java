package enspy.rmi.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.pulsar.annotation.EnablePulsar;

@EnableCassandraRepositories(basePackages = "enspy.rmi.device.repository")
@EnablePulsar
@SpringBootApplication
public class DeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceApplication.class, args);
	}

}
