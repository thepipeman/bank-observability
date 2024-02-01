package io.pipecrafts.digital.casa;

public record TransferRequest(String origin, String recipient, double amount) {
}
