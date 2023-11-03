package lotto.validation;

import lotto.utils.constant.LottoConstant;
import lotto.utils.message.ErrorMessage;

public class AmountValidation {
    public void validate(int money) {
        validateRange(money);
        validateDivisible(money);
    }

    private void validateRange(int money) {
        if (money < LottoConstant.LOTTO_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_RANGE);
        }
    }

    private void validateDivisible(int money) {
        if (money % LottoConstant.LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_AMOUNT);
        }
    }
}
