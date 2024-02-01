package io.pipecrafts.payment.transfer;

import io.pipecrafts.payment.transfer.dummy.DummyTransferRequest;
import io.pipecrafts.payment.transfer.dummy.DummyTransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transfers")
@RestController
@RequiredArgsConstructor
public class TransferController {

  private final DummyTransferService dummyTransferService;

  @PostMapping("/dummy/send")
  public String dummyTransferMoney(@Valid @RequestBody DummyTransferRequest request) {
    return dummyTransferService.sendTransfer(request);
  }

  @PostMapping("/dummy/send-failing")
  public String dummyTransferMoneyFailed(@Valid @RequestBody DummyTransferRequest request) {
    return dummyTransferService.sendFailingTransfer(request);
  }

}
