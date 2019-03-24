package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByFirstnameAndLastnameAndNationality(String firstname, String lastname, Integer nationalityId);

    List<User> findByEmailAndPassword(String email, String password);
    @Query(value="select u from User u where u.email = ?1")

    User findByEmail(String alma);

    User findById(int id);


    void deleteById(Integer id);
    User save(User u);
//    boolean updateUser(User u);


}