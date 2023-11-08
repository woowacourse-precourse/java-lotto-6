package lotto.domain;

import static lotto.view.LottoErrorMessage.INVALID_NEGATIVE_PAYMENT;

public class Payment {

    private final int payment;

    public Payment(int payment) {
        validate(payment);
        this.payment = payment;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_PAYMENT.getMessage());
        }
    }

    public double calculatePercentageOfProfit(long totalIncome) {
        return Math.round(((double) totalIncome / payment) * 100 * 100) / 100.0;
    }

    public int countAffortable(int targetPrice) {
        return payment / targetPrice;
    }
}
