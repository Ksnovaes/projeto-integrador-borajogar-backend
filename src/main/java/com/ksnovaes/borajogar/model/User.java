package com.ksnovaes.borajogar.model;

import com.ksnovaes.borajogar.enums.GameIntensity;
import com.ksnovaes.borajogar.enums.UserGender;
import com.ksnovaes.borajogar.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username; // login username

    @Column(nullable = false)
    private String password;

    private String verificationCode;

    private boolean verified = false;

    private String firstName;
    private String lastName;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private UserGender gender;
    private LocalDate birthday;

    private String favoriteTeam;
    private String favoritePlayer;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    private GameIntensity gameIntensity;

    @OneToOne(mappedBy = "creator", cascade = CascadeType.ALL)
    private Match matchCreated;

    @ManyToMany(mappedBy = "participants")
    private List<Match> matchesJoined;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
