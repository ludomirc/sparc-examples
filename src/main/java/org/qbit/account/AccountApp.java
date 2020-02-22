package org.qbit.account;


import org.qbit.account.sample.UserController;
import org.qbit.account.sample.UserService;

public class AccountApp {
    public static void main(String[] args) {

        new UserController(new UserService());
    }
}
