package lotto.util;

import static lotto.util.constant.GameRule.LOTTO_SIZE;
import static lotto.util.constant.GameRule.TICKET_PRICE;
import static lotto.util.content.ErrorMessage.INPUT_UNIT_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_SIZE_ERROR;

import java.util.List;

public class Censor {

    public static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getContent());
        }
    }

    public static void validatePurchaseUnit(Integer money) {
        if (money % TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR.getContent());
        }
    }

}
