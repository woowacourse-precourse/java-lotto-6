package lotto.controller;

import lotto.domain.payment.Payment;

import lotto.service.PaymentService;

import lotto.view.OutputView;

public final class PaymentController {
    private final PaymentService paymentService;

    PaymentController() {
        this.paymentService = new PaymentService();
    }

    public Payment processPayment() {
        OutputView.printPaymentMessage();
        Payment payment = paymentService.createPayment();
        return payment;
    }
}
