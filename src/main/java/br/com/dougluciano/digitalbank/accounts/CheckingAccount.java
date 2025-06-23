package br.com.dougluciano.digitalbank.accounts;

import br.com.dougluciano.digitalbank.customer.Customer;

public class CheckingAccount extends Account{
    public CheckingAccount(Customer customer) {
        super(customer);
    }

    @Override
    public String getAccountTypeName() {
        return "Conta corrente";
    }
}
