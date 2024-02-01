package io.pipecrafts.bank.core.casa;

import io.pipecrafts.bank.core.casa.operation.DebitAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    return Account.builder()
      .id(1L)
      .number(number)
      .balance(5000.0)
      .customerId(1L)
      .build();
  }
}
