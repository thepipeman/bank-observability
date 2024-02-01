package io.pipecrafts.digital.casa;


import lombok.Builder;

@Builder
public record Account(
  long id,
  long customerId,
  String number,
  Double balance
) {
}
