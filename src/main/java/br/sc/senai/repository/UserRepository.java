package br.sc.senai.repository;

import br.sc.senai.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.name = :nome")
    Collection<User> findAllByName(@Param("nome") String nome);
}
