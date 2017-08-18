package com.betterjavacode.benefits.managers;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.betterjavacode.benefits.entities.Role;
import com.betterjavacode.benefits.entities.User;
import com.betterjavacode.benefits.entities.UserProfile;
import com.betterjavacode.benefits.interfaces.UserManager;
import com.betterjavacode.benefits.repositories.RoleRepository;
import com.betterjavacode.benefits.repositories.UserRepository;
import com.betterjavacode.benefits.utilities.InvalidRequestException;

public class UserManagerImpl implements UserManager {

    public static final Logger LOGGER = LogManager.getLogger(UserManagerImpl.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public User createUser(User u) {
        LOGGER.info(" Enter >> createUser() ");
        if (u != null) {
            // User user = userRepository.save(u);
            User user = saveUser(u);
            LOGGER.info(" Exit << createUser() ");
            return user;
        } else {
            LOGGER.info(" Exit << createUser() ");
            throw new InvalidRequestException(400, "User is null");
        }
    }

    @Override
    public User updateUser(User u) {
        LOGGER.info(" Enter >> updateUser() ");
        User updateduser = null;
        if (u != null) {
            User user = userRepository.findOne(u.getId());
            if (user == null) {
                throw new InvalidRequestException(400, "User does not exist");
            }
            UserProfile newup = u.getUserprofile();
            UserProfile oldup = user.getUserprofile();
            newup.setId(oldup.getId());
            updateduser = userRepository.save(u);
        } else {
            LOGGER.info(" Exit << updateUser() ");
            throw new InvalidRequestException(400, "User is null");
        }
        return updateduser;
    }

    @Override
    public User getUser(int id) {
        LOGGER.info(" Enter >> getUser() ");
        User user = userRepository.findOne(id);
        if (user == null) {
            LOGGER.info(" Exit << getUser() ");
            throw new InvalidRequestException(400, "User not found ");
        }
        LOGGER.info(" Exit << getUser() ");
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.info(" Enter >> getAllUsers() ");
        List<User> userList = (List<User>) userRepository.findAll();
        LOGGER.info(" Exit << getAllUsers() ");
        return userList;
    }

    @Override
    public void deleteUser(int guid) {
        // TODO Auto-generated method stub
        LOGGER.info(" Enter >> deleteUser() ");
        User user = userRepository.findOne(guid);
        if (user == null) {
            LOGGER.info(" Exit << deleteUser() ");
            throw new InvalidRequestException(400, "User not found");
        }
        LOGGER.info(" Exit << deleteUser() ");
        userRepository.delete(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));
        Role userRole = roleRepository.findByRole(user.getRoles()
            .get(0)
            .getRole());
        user.setRoles(Arrays.asList(userRole));
        User u = userRepository.save(user);
        return u;
    }

}
