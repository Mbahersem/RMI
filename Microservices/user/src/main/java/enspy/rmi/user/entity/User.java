package enspy.rmi.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table("user")
public class User {
    @PrimaryKey
    private UUID userId;
    private String userMail;
    private String userName;
    private String userPassword;

    public User(String email, String name, String password) {
        this.userId = UUID.randomUUID();
        this.userMail = email;
        this.userName = name;
        this.userPassword = password;
    }

}


