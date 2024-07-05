package enspy.rmi.query.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table("data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataByDate {
    @PrimaryKeyColumn(name = "deviceid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID deviceId;
    @PrimaryKeyColumn(name = "date", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Date date;
    private int N;
    private int P;
    private int K;
    private int pH;
    private int T;
}
