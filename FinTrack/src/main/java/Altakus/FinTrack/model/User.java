package Altakus.FinTrack.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;

    @Column(nullable = false, scale = 2)
    private Float userTotalBudget;

    @CreationTimestamp
    @Column(name = "registration_date")
    private Date date;


    public User() {
    }
    // Геттеры сеттеры и прочая дрянь
    @PrePersist
    public void prePersist() {
        if (userTotalBudget == null) {
            userTotalBudget = 0.0f; // Или 0.0d для Double, если userTotalBudget - Double
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Float getBalance() {
        return userTotalBudget;
    }

    public void setBalance(Float balance) {
        this.userTotalBudget = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
