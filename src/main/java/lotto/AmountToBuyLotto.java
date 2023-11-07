package lotto;

import static lotto.Constants.ErrorConstant.*;
import static lotto.Constants.LottoConstant.*;

import lotto.game.LottoGame;


public class AmountToBuyLotto {

    private final Integer amount;

    public static final int ZERO = 0;

    private AmountToBuyLotto(String input) {
        isBlank(input);
        input = input.trim();
        validateNumberFormat(input);
        validateRange(input);
        isZero(input);
        validateDivisibilityByThousand(input);
        this.amount = Integer.parseInt(input);

    }

    public static AmountToBuyLotto newInstance(String amount) {
        return new AmountToBuyLotto(amount);
    }

    public Integer getAmount() {
        return amount;
    }

    public int dividedByLottoPrice() {
        return amount / LOTTO_PRICE;
    }

    private void isZero(String input) {
        if (Integer.parseInt(input) == ZERO) {
            throw new IllegalArgumentException(ERROR_NO_INPUT_ZERO);
        }
    }

    private void isBlank(String input) {
        if (input != null && !input.isBlank()) {
            return;
        }
        throw new IllegalArgumentException(ERROR_INPUT_VALID_VAULE);
    }


    private void validateRange(String amount) {
        try {
            int money = Integer.parseInt(amount);
            if (money > TWO_BILLION) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_TWO_BILLION_LESS);
        }
    }

    private void validateDivisibilityByThousand(String amount) {
        int money = Integer.parseInt(amount);
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ERROR_INPUT_UNIT_OF_THOUSAND);
        }
    }

    private void validateNumberFormat(String amount) {
        if (!amount.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ERROR_INPUT_DIGIT);
        }
    }

}
