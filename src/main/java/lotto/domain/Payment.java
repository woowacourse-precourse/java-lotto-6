package lotto.domain;

import static java.math.RoundingMode.HALF_UP;
import static lotto.domain.constants.NumberConstant.LOTTO_PRICE_UNIT;
import static lotto.domain.constants.NumberConstant.PERCENTAGE_100;
import static lotto.domain.constants.NumberConstant.SCALE_SIZE;
import static lotto.domain.enums.ExceptionMessage.MINIMUM_PAYMENT_ERROR;
import static lotto.domain.enums.ExceptionMessage.PURCHASE_AMOUNT_ERROR;
import static lotto.utils.Converter.convertToInt;

import java.math.BigDecimal;
import lotto.domain.constants.NumberConstant;
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
    
    public BigDecimal calculateProfitability(final long totalPrice) {
        if (totalPrice == NumberConstant.ZERO) {
            return BigDecimal.ZERO;
        }
        
        final BigDecimal totalPriceDecimal = new BigDecimal(totalPrice);
        final BigDecimal amountDecimal = new BigDecimal(amount);
        
        return receiveProfitability(totalPriceDecimal, amountDecimal);
    }
    
    private BigDecimal receiveProfitability(
            BigDecimal totalPriceDecimal, BigDecimal amountDecimal) {
        
        return totalPriceDecimal
                .multiply(new BigDecimal(PERCENTAGE_100))
                .divide(amountDecimal, SCALE_SIZE, HALF_UP);
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
        return amount % LOTTO_PRICE_UNIT != NumberConstant.ZERO;
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
