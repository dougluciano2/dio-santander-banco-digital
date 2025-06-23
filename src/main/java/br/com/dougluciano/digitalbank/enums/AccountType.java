package br.com.dougluciano.digitalbank.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountType {
    CHECKING("Conta corrente"),
    SAVINGS("Conta poupança");

    private final String accountDescription;
}
