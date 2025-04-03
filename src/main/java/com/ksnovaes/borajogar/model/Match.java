package com.ksnovaes.borajogar.model;

import com.ksnovaes.borajogar.enums.GameIntensity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "creator_id", unique = true)
    private User creator;

    @ManyToMany
    @JoinTable(
            name = "match_participants",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> participants;

    @Enumerated(EnumType.STRING)
    private GameIntensity gameIntensity;

    @Override
    public String toString() { // this tostring method is being used for tests
        return "Match{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", gameIntensity=" + gameIntensity +
                ", creator=" + (creator != null ? creator.getUsername() : "null") +
                '}';
    }
}
