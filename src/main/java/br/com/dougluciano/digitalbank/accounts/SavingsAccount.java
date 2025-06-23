package br.com.dougluciano.digitalbank.accounts;

import br.com.dougluciano.digitalbank.customer.Customer;

public class SavingsAccount extends Account{
    public SavingsAccount(Customer customer) {
        super(customer);
    }

    @Override
    public String getAccountTypeName() {
        return "Conta poupança";
    }
}
