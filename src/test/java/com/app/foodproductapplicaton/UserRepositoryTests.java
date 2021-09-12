package com.app.foodproductapplicaton;

import static org.assertj.core.api.Assertions.assertThat;


import com.app.foodproductapplicaton.Repository.User;
import com.app.foodproductapplicaton.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;



    @Test
    public void testCreateUser(){

        User user=new User();
        user.setEmail("anandhain21@gmail.com");
        user.setPassword("anandha");
        user.setFirstName("Anandha");
        user.setLastName("Krishnan");

        User savedUser= repository.save(user);

        User existingUser=entityManager.find(User.class,savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existingUser.getEmail());



    }


}
