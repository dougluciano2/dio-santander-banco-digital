package br.com.dougluciano.digitalbank;

import br.com.dougluciano.digitalbank.accounts.Account;
import br.com.dougluciano.digitalbank.bank.Bank;
import br.com.dougluciano.digitalbank.customer.Customer;
import br.com.dougluciano.digitalbank.enums.AccountType;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class BankApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = new Bank(33, "Banco Santander-DIO");

    public static void bankInit() {
        while (true) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consome o "enter" que sobrou do nextInt()

                switch (choice) {
                    case 1 -> createNewAccount();
                    case 2 -> depositInAccount();
                    case 3 -> withdrawFromAccount();
                    case 4 -> transferBetweenAccounts();
                    case 5 -> listAllAccounts();
                    case 6 -> showAccountStatement();
                    case 7 -> {
                        System.out.println("Obrigado por usar o Digital Bank One. Até logo!");
                        return; // Sai do método bankInit e encerra o loop
                    }
                    default -> System.err.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: por favor, digite um número válido.");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar um loop infinito
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- BEM-VINDO AO " + bank.getBankName().toUpperCase() + " ---");
        System.out.println("1. Abrir nova conta");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Realizar transferência");
        System.out.println("5. Listar todas as contas");
        System.out.println("6. Exibir extrato de uma conta");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void createNewAccount() {
        System.out.print("Digite o nome completo do cliente: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);

        System.out.print("Escolha o tipo de conta (1 para Corrente, 2 para Poupança): ");
        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consome o "enter"

        AccountType accountType = switch (accountTypeChoice) {
            case 1 -> AccountType.CHECKING;
            case 2 -> AccountType.SAVINGS;
            default -> null;
        };

        if (accountType != null) {
            Account newAccount = bank.createAccount(customer, accountType);
            System.out.printf("Sucesso! %s criada para %s.%n", newAccount.getAccountTypeName(),
                    newAccount.getCustomer().getCustomerFullName());
        } else {
            System.err.println("Tipo de conta inválido.");
        }
    }

    private static void depositInAccount() {
        System.out.print("Digite o número da conta para depósito: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Digite o valor a ser depositado: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consome o "enter"

        Optional<Account> accountOpt = bank.getAccountByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            accountOpt.get().deposit(amount);
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.err.println("Conta não encontrada.");
        }
    }

    private static void withdrawFromAccount() {
        System.out.print("Digite o número da conta para saque: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Digite o valor a ser sacado: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consome o "enter"

        Optional<Account> accountOpt = bank.getAccountByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            accountOpt.get().withdraw(amount);
            System.out.println("Saque realizado com sucesso. Verifique o saldo.");
        } else {
            System.err.println("Conta não encontrada.");
        }
    }

    private static void transferBetweenAccounts() {
        System.out.print("Digite o número da conta de ORIGEM: ");
        int sourceAccountNumber = scanner.nextInt();
        System.out.print("Digite o número da conta de DESTINO: ");
        int destAccountNumber = scanner.nextInt();
        System.out.print("Digite o valor a ser transferido: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consome o "enter"

        bank.transfer(sourceAccountNumber, destAccountNumber, amount);

    }

    private static void listAllAccounts() {
        bank.listAllAccounts();
    }

    private static void showAccountStatement() {
        System.out.print("Digite o número da conta para ver o extrato: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consome o "enter"

        Optional<Account> accountOpt = bank.getAccountByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            accountOpt.get().bankStatement();
        } else {
            System.err.println("Conta não encontrada.");
        }
    }
}

