package io.pipecrafts.digital.casa;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RequestMapping("/account-operations")
@RestController
@RequiredArgsConstructor
public class AccountOperationController {

  private final CoreAccountApi coreAccountApi;
  private final DummyTransferApi dummyTransferApi;


  @PostMapping("/transfer-funds")
  public String transferFunds(@RequestBody @Valid TransferRequest request) {

    final var account = coreAccountApi.readByNumber(request.origin());
    final var debitReference = coreAccountApi.debit(new DebitAccountRequest(account.number(), request.amount()));
    final var transferReference = dummyTransferApi.dummyTransferMoney(
      DummyTransferRequest.builder()
        .amount(request.amount())
        .bankCode("CITI")
        .recipient(request.recipient())
        .origin(request.origin())
        .referenceNumber(UUID.randomUUID().toString())
        .build()
    );

    log.info("Transfer funds successful [customerId=<{}>, debitReference=<{}>, reference=<{}>]", account.customerId(), debitReference, transferReference);
    return transferReference;
  }
}
