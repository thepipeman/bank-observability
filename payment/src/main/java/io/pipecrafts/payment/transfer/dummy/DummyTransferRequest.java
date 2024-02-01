package io.pipecrafts.payment.transfer.dummy;

public record DummyTransferRequest(
  String origin,
  String recipient,
  String referenceNumber,
  String bankCode,
  Double amount
) {
}
