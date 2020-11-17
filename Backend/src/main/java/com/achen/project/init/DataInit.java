package com.achen.project.init;

import com.achen.project.repository.DeviceRepository;
import com.achen.project.repository.entity.Device;
import com.achen.project.security.repository.UserRepository;
import com.achen.project.security.repository.entity.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataInit implements ApplicationRunner {

    @Value("${admin.username}")
    String username;

    @Value("${admin.password}")
    String password;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Device dev = new Device("N10L01D01","Front Desk","Smoke Detector","Normal");
        Device devOne = new Device("N10L01D02","Front Desk Elevator Lobby","Smoke Detector","Normal");
        Device devTwo = new Device("N10L01D03","1st Floor Mail Room","Smoke Detector","Normal");
        deviceRepository.saveAll(Arrays.asList(dev,devOne,devTwo));

        final User user = new User();
        user.setEmail(username);
        user.setPassword(password);

        userRepository.save(user);
    }
}
