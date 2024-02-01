package io.pipecrafts.bank.core.customer;

public record Customer(
  long id,
  String number,
  String firstName,
  String lastName
) {
}
