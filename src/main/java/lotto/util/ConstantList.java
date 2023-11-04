package lotto.util;

import static lotto.util.ConstantMessages.BONUS_RESULT_MESSAGE;
import static lotto.util.ConstantMessages.NONE_BONUS_RESULT_MESSAGE;
import static lotto.util.ConstantNumbers.LOTTO_FIFTH_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_FIFTH_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_FIRST_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_FIRST_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_FOURTH_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_FOURTH_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_SECOND_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_SECOND_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_THIRD_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_THIRD_QUANTITY;

import java.util.List;

public enum ConstantList {
    MONEY_EACH_GRADE(
        List.of(
            LOTTO_FIFTH_MONEY.getConstant(),
            LOTTO_FOURTH_MONEY.getConstant(),
            LOTTO_THIRD_MONEY.getConstant(),
            LOTTO_SECOND_MONEY.getConstant(),
            LOTTO_FIRST_MONEY.getConstant()
        )
    ),
    LOTTO_QUANTITY_EACH_GRADE(
        List.of(
            LOTTO_FIFTH_QUANTITY.getConstant(),
            LOTTO_FOURTH_QUANTITY.getConstant(),
            LOTTO_THIRD_QUANTITY.getConstant(),
            LOTTO_SECOND_QUANTITY.getConstant(),
            LOTTO_FIRST_QUANTITY.getConstant()
        )
    ),
    RESULT_MESSAGE_EACH_GRADE(
        List.of(
            NONE_BONUS_RESULT_MESSAGE.getMessage(),
            NONE_BONUS_RESULT_MESSAGE.getMessage(),
            NONE_BONUS_RESULT_MESSAGE.getMessage(),
            BONUS_RESULT_MESSAGE.getMessage(),
            NONE_BONUS_RESULT_MESSAGE.getMessage()
        )
    );

    private final List<Object> constantNumber;

    ConstantList (List<Object> constantNumber) {
        this.constantNumber = constantNumber;
    }

    public List<Object> getConstant() {
        return constantNumber;
    }
}
