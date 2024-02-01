package io.pipecrafts.digital.casa;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dummy-transfer", path = "/transfers")
interface DummyTransferApi {

  @PostMapping("/dummy/send")
  String dummyTransferMoney(@RequestBody DummyTransferRequest request);

  @PostMapping("/dummy/send-failing")
  String dummyTransferMoneyFailed(@RequestBody DummyTransferRequest request);
}
