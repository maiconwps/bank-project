package com.br.letscode.databaseproject.user.repository;

import com.br.letscode.databaseproject.user.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Profile("test")
class IUserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    IUserRepository userRepository;

    @Test
    void valid_if_no_exist_user_with_cpf() {
        boolean existUser = userRepository.existUserWithCpf("12345678900");
        Assertions.assertFalse(existUser);
    }

    @Test
    void valid_if_exist_user_with_cpf() {
        User user = new User();
        user.setCpf("12345678900");
        user.setPassword("12345678");
        user.setEmail("test@gmail.com");
        user.setName("Teste user");

        entityManager.persist(user);

        boolean existUser = userRepository.existUserWithCpf("12345678900");
        Assertions.assertTrue(existUser);
    }

    @Test
    void valid_if_no_exist_user_with_email() {
        boolean existUser = userRepository.existUserWithEmail("test@gmail.com");
        Assertions.assertFalse(existUser);
    }

    @Test
    void valid_if_exist_user_with_email() {
        User user = new User();
        user.setCpf("12345678900");
        user.setPassword("12345678");
        user.setEmail("test@gmail.com");
        user.setName("Teste user");

        entityManager.persist(user);

        boolean existUser = userRepository.existUserWithEmail("test@gmail.com");
        Assertions.assertTrue(existUser);
    }
}