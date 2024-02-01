package io.pipecrafts.digital.casa;

import lombok.Builder;

@Builder
public record DummyTransferRequest(
  String origin,
  String recipient,
  String referenceNumber,
  String bankCode,
  Double amount
) {
}
