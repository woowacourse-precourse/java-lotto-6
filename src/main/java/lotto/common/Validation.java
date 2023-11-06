package lotto.common;

import java.util.List;

import static lotto.domain.LottoConst.*;

public class Validation {

    public int validatePurchaseMoney(String input) {
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput < LOTTO_PRICE) throw new IllegalArgumentException(NOT_PURCHASE_MONEY_OVER_1000);
            if (parseInput % LOTTO_PRICE != 0) throw new IllegalArgumentException(NOT_PURCHASE_MONEY_DIVIDE_1000);
            return parseInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_NUMBER);
        }
    }
}
