package br.com.dougluciano.digitalbank.accounts;

public interface AccountOps {

    void withdraw(Double value);

    void deposit(Double value);

    void transfer(Double value, AccountOps destinationAccount);

    void bankStatement();
}
