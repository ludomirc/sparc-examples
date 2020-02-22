package org.qbit.account;

import org.qbit.account.model.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> getAccount(String accountId);
    Optional<Account> addAccount(Account account);
}
