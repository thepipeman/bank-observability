package io.pipecrafts.digital.casa;

public record TransferResponse(
  String debitReference,
  String transferReference
) {
}
