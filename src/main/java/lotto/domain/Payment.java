package lotto.domain;

import java.text.DecimalFormat;

import static lotto.exception.ErrorMessage.INVALID_PAYMENT_FORM;
import static lotto.exception.ErrorMessage.INVALID_PAYMENT_RANGE;

public class Payment {
    private final static int PRICE_PER_LOTTO = 1000;
    private final static int PERCENT_MAKER = 100;

    private final int pay;

    public Payment(int pay) {
        validateRange(pay, PRICE_PER_LOTTO);
        validateDivisibility(pay, PRICE_PER_LOTTO);
        this.pay = pay;
    }

    private void validateRange(int pay, int lottoPrice) {
        if (pay < lottoPrice) {
            throw new IllegalArgumentException(INVALID_PAYMENT_RANGE.getMessage());
        }
    }

    private void validateDivisibility(int pay, int lottoPrice) {
        if (pay % lottoPrice != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT_FORM.getMessage());
        }
    }

    public int calculateLottoAmount() {
        return pay / PRICE_PER_LOTTO;
    }

    public String getReturnRate(int reward) {
        double result = (double) reward / pay * PERCENT_MAKER;
        return formatReturnRate(result);
    }

    private String formatReturnRate(Double reward) {
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        return formatter.format(reward);
    }
}
