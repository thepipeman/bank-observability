package io.pipecrafts.digital.casa;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "core-accounts", path = "/accounts")
interface CoreAccountApi {

  @GetMapping
  Account readByNumber(@RequestParam("number") String number);

  @PostMapping("/debit-account")
  String debit(@RequestBody DebitAccountRequest request);

}
