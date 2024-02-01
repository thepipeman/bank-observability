package io.pipecrafts.bank.core.casa.operation;

import io.pipecrafts.bank.core.casa.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Function;

@Slf4j
@Service
public class DebitAccount implements Function<DebitAccount.Input, String> {

  public record Input(String number, double amount) {
  }

  @Override
  public String apply(Input input) {
    final var account = getDummy(input.number);
    if (input.amount > account.balance()) {
      // throw exception
    }

    final var remainingBalance = account.balance() - input.amount;
    log.info("Account {} debited with {}, remaining balance {}.", account.number(), input.amount, remainingBalance);
    return UUID.randomUUID().toString();
  }

  private Account getDummy(String number) {
    return Account.builder()
      .id(1L)
      .number(number)
      .balance(5000.0)
      .customerId(1L)
      .build();
  }
}
