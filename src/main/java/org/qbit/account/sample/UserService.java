package org.qbit.account.sample;

import java.util.Arrays;
import java.util.List;


public class UserService {

    public List<User> getAllUsers() {
        return Arrays.asList(new User("t1"));
    }

}