package ru.example.spring.boot_security.demo.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message ="The field cannot be empty")
    @Pattern(regexp = "[A-Za-z][а-яёА-ЯЁ]{2,15}", message = "Name should be between 2 and 15 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message ="The field cannot be empty")
    @Pattern(regexp = "[A-Za-z][а-яёА-ЯЁ]{2,15}", message = "Surname should be between 2 and 15 characters")
    @Column(name = "surname")
    private String surname;

    @NotEmpty(message ="The field cannot be empty")
    @Pattern(regexp = "[A-Za-z][а-яёА-ЯЁ]{2,15}", message = "Username should be between 2 and 15 characters")
    @Column(name = "username")
    private String username;

    @NotEmpty(message ="The field cannot be empty")
    @Email(message = "Enter correct email")
    @Column(name = "email")
    private String email;

    @NotEmpty(message ="The field cannot be empty")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ToString.Exclude
    private List<Role> roles;


    public User(String name, String surname, String username, String email, String password, List<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(Long id, String name, String surname, String username, String email, String password, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
