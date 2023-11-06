package lotto.validation;

import lotto.config.ConstantNum;
import lotto.config.ErrorMessage;

import java.util.List;

public class DomainValidate {
    private DomainValidate() {
    }

    public static void validateNumberInRange(int num) {
        if (num < ConstantNum.LOTTO_NUMBER_MIN.getNum() || num > ConstantNum.LOTTO_NUMBER_MAX.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    public static void validateNumberOfLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != ConstantNum.LOTTO_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_LOTTO_NUMBERS.getMessage());
        }
    }

    public static void validateNumberOfBonus(List<Integer> bonus) {
        if (bonus.size() != ConstantNum.LOTTO_BONUS_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_BONUS.getMessage());
        }
    }
}
