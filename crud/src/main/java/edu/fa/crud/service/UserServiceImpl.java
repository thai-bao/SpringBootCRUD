package edu.fa.crud.service;

import edu.fa.crud.entity.Users;
import edu.fa.crud.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Users addOrUpdateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users deleteUser(int userId) throws Exception {
        Users deletedUser = null;
        try {
            deletedUser = userRepository.findById(userId).orElse(null);
            if (deletedUser == null) {
                throw new Exception("User does not exist");
            } else {
                userRepository.deleteById(userId);
            }
        }
        catch(Exception ex) {
            throw ex;
        }
        return deletedUser;
    }
}
