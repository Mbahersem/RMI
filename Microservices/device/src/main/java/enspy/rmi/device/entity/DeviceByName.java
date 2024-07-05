package enspy.rmi.device.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(value = "device_by_name")
public class DeviceByName {
    @PrimaryKeyColumn(name = "devicename", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String deviceName;
    @PrimaryKeyColumn(name = "userid", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID userId;
    private UUID deviceId;
}
