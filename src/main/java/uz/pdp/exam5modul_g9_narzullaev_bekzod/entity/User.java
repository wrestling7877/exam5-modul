package uz.pdp.exam5modul_g9_narzullaev_bekzod.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String role= Role.USER.name();

}
