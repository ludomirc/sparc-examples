package org.qbit.account.model;

import lombok.Data;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

@Data
public class Account {

    private String accountId;
    private CurrencyUnit currency;
    private Money balance;

    public CurrencyUnit getCurrency(){
         return this.balance.getCurrencyUnit();
    }
}
