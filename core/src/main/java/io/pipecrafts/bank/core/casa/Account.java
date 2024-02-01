package io.pipecrafts.bank.core.casa;


import lombok.Builder;

@Builder
public record Account(
  long id,
  long customerId,
  String number,
  Double balance
) {
}
