package br.com.dougluciano.digitalbank.accounts;

import br.com.dougluciano.digitalbank.customer.Customer;
import lombok.Getter;

@Getter
public abstract class Account implements AccountOps {

    private static final int STANDARD_BANK_OFFICE_CODE = 1;
    private static int SEQUENCE = 1;

    protected int bankOfficeCode;
    protected int accountNumber;
    protected double balance;
    protected Customer customer;

    public Account(Customer customer){
        this.bankOfficeCode = Account.STANDARD_BANK_OFFICE_CODE;
        this.accountNumber = Account.SEQUENCE++;
        this.customer = customer;
        this.balance = 0.0;
    }

    public String showCurrentBalance(){
        return String.format("O saldo atual da conta é: %f", getBalance());
    }

    @Override
    public void withdraw(Double value) {
        if (value > 0 && this.balance >= value) {
            this.balance -= value;
            System.out.println(showCurrentBalance());
        } else {
            System.err.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    @Override
    public void deposit(Double value) {
        if (value > 0) {
            this.balance += value;
            System.out.println(showCurrentBalance());
        } else {
            System.err.println("Valor de depósito inválido.");
        }
    }

    @Override
    public void transfer(Double value, AccountOps destinationAccount) {
        if (value > 0 && this.balance >= value) {
            this.withdraw(value);
            destinationAccount.deposit(value);
            System.out.println(showCurrentBalance());
        } else {
            System.err.println("Saldo insuficiente ou valor de transferência inválido.");
        }
    }

    @Override
    public void bankStatement(){
        String accountTypeHeader;

        if (this instanceof SavingsAccount) {
            accountTypeHeader = "=== Extrato Conta Poupança ===";
        } else if (this instanceof CheckingAccount) {
            accountTypeHeader = "=== Extrato Conta Corrente ===";
        } else {
            accountTypeHeader = "=== Extrato de Conta ==="; // Um valor padrão
        }

        System.out.println(accountTypeHeader);
        System.out.println("---");
        System.out.printf("Titular: %s%n", this.customer.getCustomerFullName());
        System.out.printf("Agência: %d%n", this.bankOfficeCode);
        System.out.printf("Conta: %d%n", this.accountNumber);
        System.out.println(showCurrentBalance());
        System.out.println("==============================");

    }

}
