package com.br.letscode.databaseproject.user.repository;

import com.br.letscode.databaseproject.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT CASE  WHEN count(u)> 0 THEN true ELSE false END FROM User u WHERE u.cpf = :cpf")
    boolean existUserWithCpf(@Param("cpf") String cpf);

    @Query(value = "SELECT CASE  WHEN count(u)> 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
    boolean existUserWithEmail(@Param("email") String email);

}
