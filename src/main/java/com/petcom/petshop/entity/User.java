package com.petcom.petshop.entity;
import javax.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern (regexp = "^[a-zA-Z0-9._-]{3,}$", message = "Username must be at least 3 characters long and can contain letters, numbers, dots, underscores, and hyphens.")
    @Column(name = "username")
    private String userName;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", message = "Password must be at least 8 characters long and contain both letters and numbers.")
    @Column(name = "password")
    private String password;

    @Email(message="email should be valid")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits.")
    @Column(name = "phone_no")
    private Long phoneNo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "is_active")
    private Boolean isActive;

    public void setRole(int i, String s) {
    }
}
