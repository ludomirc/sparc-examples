package org.qbit.account;

import org.qbit.account.model.Account;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {

    public static final AccountService INSTANCE = new AccountServiceImpl();
    private ConcurrentHashMap<String,Account> accounts;

    private AccountServiceImpl(){
        this.accounts = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<Account> getAccount(String accountId) {

        return  Optional.of(accounts.get(accountId));
    }

    @Override
    public Optional<Account> addAccount(Account account) {
        if(!accounts.contains(account.getAccountId())) return Optional.empty();
        return Optional.of( accounts.put(account.getAccountId(),account));
    }

    public List<Account> getAccounts(){
        return (List<Account>) accounts.values();
    }

    public void setAccounts(Collection<Account> accounts){
            accounts.stream().collect(Collectors.toMap(Account::getAccountId,s-> s));
    }
}
