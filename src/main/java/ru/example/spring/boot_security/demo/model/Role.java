package ru.example.spring.boot_security.demo.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private List<User> users;

    public Role(String name) {
        this.role = name;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getNoPrefix() {
        String pr = "ROLE_";
        return role.substring(pr.length());
    }

    @Override
    public String getAuthority() {
        return getRole();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
