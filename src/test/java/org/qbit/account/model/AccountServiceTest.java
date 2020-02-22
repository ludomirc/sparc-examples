package org.qbit.account.model;


import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.qbit.account.AccountService;
import org.qbit.account.AccountServiceImpl;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.joda.money.CurrencyUnit.USD;

public class AccountServiceTest {

        AccountService accountService = AccountServiceImpl.INSTANCE;

        @Test
        void whenClientAskAboutNotExistingAccount_ThenIsReturnedEmptyOptional(){
            String expectedAccountId = "testAccountId";

            Optional<Account> actualAccount =  accountService.getAccount(expectedAccountId);

            Optional<Account>  expectedAccount = Optional.empty();
            assertThat(actualAccount.isEmpty(), is(equalTo(expectedAccount.isEmpty())));
        }

    @Test
    void whenIsGivenAccount_thenAddAccount(){
        String expectedAccountId = "testAccountId";
        CurrencyUnit expectedCurrency  = USD;
        double expectedBalance = 0;
        Money expectedBalanceMoney = Money.of(expectedCurrency,expectedBalance);

        Account expectedAccount = new Account();
        expectedAccount.setAccountId(expectedAccountId);
        expectedAccount.setBalance(expectedBalanceMoney);
        Optional<Account> expectedOptionalAccount = Optional.of(expectedAccount);

        accountService.addAccount(expectedAccount);
        Optional<Account> actualAccountOptional =  accountService.getAccount(expectedAccountId);

        assertThat(actualAccountOptional.isPresent(), is(expectedOptionalAccount.isPresent()));

        Account actualAccount = actualAccountOptional.get();
        assertThat(actualAccount.getAccountId(),is(equalTo(expectedAccountId)));
        assertThat(actualAccount.getCurrency(),is(equalTo(expectedCurrency)));
        assertThat(actualAccount.getBalance(),is(equalTo(expectedBalanceMoney)));
    }
}
