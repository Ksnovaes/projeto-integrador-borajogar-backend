package com.ksnovaes.borajogar.repositories;

import com.ksnovaes.borajogar.enums.GameIntensity;
import com.ksnovaes.borajogar.enums.UserGender;
import com.ksnovaes.borajogar.enums.UserStatus;
import com.ksnovaes.borajogar.model.Address;
import com.ksnovaes.borajogar.model.Match;
import com.ksnovaes.borajogar.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TestRepositories {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void UserCreationTest() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@gmail.com");
        user.setPassword("123456");
        user.setBirthday(LocalDate.of(1990, 1, 1));
        user.setGender(UserGender.MALE);
        user.setCreatedAt(LocalDateTime.now());
        user.setFavoritePlayer("Lebron James");
        user.setFavoriteTeam("Lakers");
        user.setStatus(UserStatus.ACTIVE);
        user.setVerificationCode("1234");
        user.setVerified(true);
        user.setGameIntensity(GameIntensity.PRO);
        user.setUsername("Jdoe");

        userRepository.save(user);

        System.out.println("User saved: " + user);

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@gmail.com");
        user2.setPassword("123456");
        user2.setBirthday(LocalDate.of(1990, 1, 1));
        user2.setGender(UserGender.FEMALE);
        user2.setCreatedAt(LocalDateTime.now());
        user2.setFavoritePlayer("Lebron James");
        user2.setFavoriteTeam("Lakers");
        user2.setStatus(UserStatus.ACTIVE);
        user2.setVerificationCode("1234");
        user2.setVerified(true);
        user2.setGameIntensity(GameIntensity.PRO);
        user2.setUsername("Jane");

        userRepository.save(user2);

        System.out.println("User saved: " + user2);
    }

    @Test
    public void MatchCreationTest() {
        Address address = new Address();
        address.setStreet("Rua das Quadras");
        address.setCity("São Paulo");
        address.setState("SP");
        address.setZip("01000-000");
        address.setLatitude(-23.55052);
        address.setLongitude(-46.633308);
        addressRepository.save(address);
        System.out.println("Address saved: " + address);

        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            System.out.println("Not Found");
            return;
        }

        User creator = users.get(0);
        User participant = users.get(1);

        Match match = new Match();
        match.setTitle("Basketball Game");
        match.setDescription("Game");
        match.setDateTime(LocalDateTime.now().plusDays(1));
        match.setAddress(address);
        match.setCreator(creator);
        match.setGameIntensity(GameIntensity.PRO);
        match.setParticipants(List.of(participant));

        matchRepository.save(match);
        System.out.println("Match saved: " + match);
    }
}
