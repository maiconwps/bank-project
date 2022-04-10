package com.br.letscode.databaseproject.user.repository;

import com.br.letscode.databaseproject.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
