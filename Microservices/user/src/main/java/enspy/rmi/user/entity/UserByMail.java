package enspy.rmi.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(value = "user_by_mail")
public class UserByMail {
    @PrimaryKeyColumn(name = "usermail", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String userMail;
    @PrimaryKeyColumn(name = "userid", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID userId;

    public UserByMail(String userMail) {
        this.userMail = userMail;
        this.userId = UUID.randomUUID();
    }
}


