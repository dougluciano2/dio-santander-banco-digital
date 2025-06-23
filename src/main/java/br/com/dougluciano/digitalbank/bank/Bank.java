package br.com.dougluciano.digitalbank.bank;

import br.com.dougluciano.digitalbank.accounts.Account;
import br.com.dougluciano.digitalbank.accounts.CheckingAccount;
import br.com.dougluciano.digitalbank.accounts.SavingsAccount;
import br.com.dougluciano.digitalbank.customer.Customer;
import br.com.dougluciano.digitalbank.enums.AccountType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Bank {

    private Integer bankCode;
    private String bankName;
    private List<Account> accounts;

    public Bank(Integer bankCode,String bankName){
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public Account createAccount(Customer customer, AccountType accountType){
        Account newAccount;

        switch (accountType){
            case SAVINGS -> newAccount = new SavingsAccount(customer);
            case CHECKING -> newAccount = new CheckingAccount(customer);
            default -> throw new IllegalArgumentException("Tipo de conta inválido.");
        }

        this.accounts.add(newAccount);
        newAccount.getAccountInfo();
        return newAccount;
    }

    public void listAllAccounts(){
        System.out.println("=== LISTA DE CLIENTE DO BANCO " + this.bankName + " ===");
        this.accounts.forEach(a -> {
            String customerName = a.getCustomer().getCustomerFullName();
            String accountInfo = a.getAccountInfo();

            System.out.printf("Titular: %-25s | Conta: %s%n", customerName, accountInfo);
        });
    }

    public Optional<Account> getAccountByNumber(int number){
        return this.accounts.stream().filter(a -> a.getAccountNumber() == number).findFirst();

    }

    public void transfer(int sourceAccountNumber, int destAccountNumber, double amount) {
        Optional<Account> sourceAccountOpt = getAccountByNumber(sourceAccountNumber);
        Optional<Account> destAccountOpt = getAccountByNumber(destAccountNumber);

        if (sourceAccountOpt.isEmpty() || destAccountOpt.isEmpty()) {
            System.err.println("Erro: Conta de origem ou destino não encontrada.");
            return;
        }

        if (sourceAccountNumber == destAccountNumber) {
            System.err.println("Erro: A conta de origem e destino não podem ser a mesma.");
            return;
        }

        Account sourceAccount = sourceAccountOpt.get();
        Account destAccount = destAccountOpt.get();

        sourceAccount.transfer(amount, destAccount);
        System.out.println("Operação de transferência processada.");
    }


}
