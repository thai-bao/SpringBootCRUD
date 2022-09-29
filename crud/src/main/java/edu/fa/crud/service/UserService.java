package edu.fa.crud.service;

import edu.fa.crud.entity.Users;

import java.util.List;

public interface UserService {
     List<Users> getAllUsers();
     Users getUserById(int userId);
     Users addOrUpdateUser(Users user);
     Users deleteUser(int userId) throws Exception;
}
