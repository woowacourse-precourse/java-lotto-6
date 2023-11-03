package lotto.util;

import static lotto.constant.LottoInformation.LOTTO_PRICE;
import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS;
import static lotto.constant.message.ErrorMessage.HAS_REMAINDER;
import static lotto.constant.message.ErrorMessage.NOT_ONLY_DIGIT;

import java.util.List;

public class Validation {

    /* 금액 관련
     * 1. 숫자가 아닌 경우
     * 2. 1000원으로 나누어 떨어지지 않는 경우
     * */

    public void validateOnlyDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT);
        }
    }

    public void validateMultiplesOfPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(HAS_REMAINDER);
        }
    }

    public void validateDuplicateBonus(List<Integer> winningNumber, int bonus) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS);
        }
    }

    public boolean validateNumberRange(int number) {
        return number >= MIN_NUMBER && number < MAX_NUMBER;
    }


}
