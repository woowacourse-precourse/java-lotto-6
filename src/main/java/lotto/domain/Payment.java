package lotto.domain;

public class Payment {
    private final static int PRICE_PER_LOTTO = 1000;

    private final int pay;

    public Payment(int pay) {
        validateRange(pay, PRICE_PER_LOTTO);
        validateDivisibility(pay, PRICE_PER_LOTTO);
        this.pay = pay;
    }

    private void validateRange(int pay, int lottoPrice) {
        if (pay < lottoPrice) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisibility(int pay, int lottoPrice) {
        if (pay % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
    }
}
