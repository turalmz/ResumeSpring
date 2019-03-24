package com.company.service.impl;

import com.company.dao.impl.UserRepository;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao;

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public List<User> getAll(String firstname, String lastname, Integer nationalityId) {
        //return userRepository.findByFirstnameAndLastnameAndNationality(firstname, lastname, nationalityId);
        return userDao.getAll(firstname,lastname,nationalityId);

    }



    //Native SQL
    @Override
    public User findByEmail(String email) {

        return userDao.findByEmail(email);
    }

    @Override
    public boolean updateUser(User u) {
//        return userRepository.save(u)== u;
        return  userDao.updateUser(u);
    }

    @Override
    public boolean removeUser(Integer id) {
//         userRepository.deleteById(id);
////         return true;
        return userDao.removeUser(id);
    }

    @Override
    public User getById(int userId) {

//        return userRepository.findById(userId);
        return userDao.getById(userId);
    }

    @Override
    public boolean addUser(User u) {
//         userRepository.save(u);
//         return true;
        return  userDao.addUser(u);
    }

}