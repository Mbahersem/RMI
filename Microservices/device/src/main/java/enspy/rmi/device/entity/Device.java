package enspy.rmi.device.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("device")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Device {
    @PrimaryKey
    private UUID deviceId;
    private String deviceName;
    private String support;
    private String api;
    private String typeMcu;

    public Device(String deviceName, String support, String type) {
        this.deviceId = UUID.randomUUID();
        this.deviceName = deviceName;
        this.support = support;
        this.typeMcu = type;
    }
}
