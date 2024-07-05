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
@Table(value = "devices_by_user")
public class DeviceByUser {
    @PrimaryKeyColumn(name = "userid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID userId;
    @PrimaryKeyColumn(name = "devicename", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String deviceName;
    private UUID deviceId;
}
