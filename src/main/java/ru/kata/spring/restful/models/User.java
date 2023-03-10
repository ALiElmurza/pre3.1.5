package ru.kata.spring.restful.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.restful.models.Role;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "hashPassword")
    private String hashPassword;



    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name="user_roles",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {

    }

    public User(String username, String password, String firstname, String lastname, int age, String email) {
        this.username = username;
        this.password = password;
        this.hashPassword = password;
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = age;
        this.email = email;

    }
    public User(String username, String password, String firstname, String lastname, int age, String email, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.hashPassword = password;
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = age;
        this.email = email;
        this.roles = roles;
    }

    public void addRoleToUser(Role role) {
        if (roles == null) {
            roles = new HashSet<>();
        }
        roles.add(role);
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getRoles(){
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public String getRolesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Role role : roles) {
            stringBuilder.append(role.getName()).append(" ");
        }
        return stringBuilder.toString();
    }



    @Override
    public String toString() {
        return "Nickname: " + username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
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
}
