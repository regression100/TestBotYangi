package TajribaUchun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String tgID;
    String userName;
    String firstName;
    String lastName;
    String phone;
}
