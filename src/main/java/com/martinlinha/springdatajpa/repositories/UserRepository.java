package com.martinlinha.springdatajpa.repositories;

import com.martinlinha.springdatajpa.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by martinlinha on 05.09.17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAllByEmail(String email);

    List<User> findAllByNameEndingWith(String ending);

    List<User> findAllByNameEqualsOrNameEquals(String one, String two);

    List<User> findByHomeAddressCountry(String country);

    List<User> findByHomeAddressCityAllIgnoreCase(String country);

    User findFirstByWorkAddressZipCode(Integer zipCode);

    List<User> findTop2ByHomeAddressCountry(String country);

    Page<User> findByHomeAddressCountry(String country, Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.age BETWEEN :from AND :to")
    List<User> allUsersBetweenAge(@Param("from") Integer from, @Param("to") Integer to);
}
