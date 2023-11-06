package lotto.domain;

import static lotto.exception.ExceptionMessage.MINIMUM_PAYMENT_ERROR;
import static lotto.exception.ExceptionMessage.PURCHASE_AMOUNT_ERROR;
import static lotto.utils.Converter.convertToInt;
import static lotto.view.NumberConstant.LOTTO_PRICE_UNIT;
import static lotto.view.NumberConstant.ZERO;

import lotto.exception.LottoGameException;

public class Payment {
    
    private final Integer amount;
    
    private Payment(final String input) {
        int amount = convertToInt(input);
        validate(amount);
        this.amount = amount;
    }
    
    public static Payment from(final String amount) {
        return new Payment(amount);
    }
    
    public int receiveIssuedLottoCount() {
        return amount / LOTTO_PRICE_UNIT;
    }
    
    private void validate(final int amount) {
        validateRange(amount);
        validateCurrencyDivision(amount);
    }
    
    private void validateCurrencyDivision(final int amount) {
        if (notValidateCurrencyDivision(amount)) {
            throw LottoGameException.from(PURCHASE_AMOUNT_ERROR);
        }
    }
    
    private boolean notValidateCurrencyDivision(final int amount) {
        return amount % LOTTO_PRICE_UNIT != ZERO;
    }
    
    private void validateRange(final int amount) {
        if (isSmallerThanMinimumPayment(amount)) {
            throw LottoGameException.from(MINIMUM_PAYMENT_ERROR);
        }
    }
    
    private boolean isSmallerThanMinimumPayment(final int amount) {
        return amount < LOTTO_PRICE_UNIT;
    }
}
