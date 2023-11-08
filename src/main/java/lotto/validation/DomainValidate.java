package lotto.validation;

import lotto.config.ConstantNum;
import lotto.config.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomainValidate {
    private DomainValidate() {
    }

    public static void validateNumberInRange(int num) {
        if (num < ConstantNum.LOTTO_NUMBER_MIN.getNum() || num > ConstantNum.LOTTO_NUMBER_MAX.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    public static void validateNumberOfWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != ConstantNum.WINNING_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_WINNING_NUMBERS.getMessage());
        }
    }

    public static void validateNumberOfBonus(List<Integer> bonus) {
        if (bonus.size() != ConstantNum.LOTTO_BONUS_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_BONUS.getMessage());
        }
    }

    public static void validateNegativeMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NEGATIVE_NUMBER.getMessage());
        }
    }

    public static void validateDuplicated(List<Integer> numbers) {
        Set<Integer> result = new HashSet<>();
        for (Integer number : numbers) {
            result.add(number);
        }
        if (result.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }
}
