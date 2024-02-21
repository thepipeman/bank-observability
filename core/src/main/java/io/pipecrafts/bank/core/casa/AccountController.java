package io.pipecrafts.bank.core.casa;

import io.pipecrafts.bank.core.casa.operation.DebitAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/accounts")
@RestController
@RequiredArgsConstructor
public class AccountController {

  private final DebitAccount debitAccount;

  @GetMapping
  public Account readByNumber(@RequestParam("number") String number) {
    return getDummy(number);
  }

  @PostMapping("/debit-account")
  public String debit(@RequestBody DebitAccount.Input request) {
    return debitAccount.apply(request);
  }

  private Account getDummy(String number) {
    final var account = Account.builder()
      .id(1L)
      .number(number)
      .balance(5000.0)
      .customerId(1L)
      .build();

    log.info("Returning account {}", account);
    return account;
  }
}
