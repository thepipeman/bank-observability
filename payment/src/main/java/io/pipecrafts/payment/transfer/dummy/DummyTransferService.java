package io.pipecrafts.payment.transfer.dummy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class DummyTransferService {

  public String sendTransfer(DummyTransferRequest request) {
    log.info("Successfully sent {} to target account [referenceNumber=<{}>]]", request.amount(), request.referenceNumber());
    return UUID.randomUUID().toString();
  }

  public String sendFailingTransfer(DummyTransferRequest request) {
    log.info("Failed to send transfer [referenceNumber=<{}>]", request.referenceNumber());
    // throw exception
    return UUID.randomUUID().toString();
  }
}
