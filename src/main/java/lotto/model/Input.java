package lotto.model;

import static lotto.model.ErrorMessage.BONUS_DUPLICATE_ERROR;
import static lotto.model.ErrorMessage.INPUT_POSITIVE_ERROR;
import static lotto.model.ErrorMessage.LOTTO_RANGE_ERROR;
import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;

import java.util.Arrays;
import java.util.List;

public class Input {

    public static final String SPLIT_SENTENCE = ",";
    public static final String POSITIVE_NUMBER_PATTERN = "\\d+$";

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public Money ofMoney() {
        return new Money(input);
    }

    public List<Integer> ofNums() {
        return Arrays.stream(input.split(SPLIT_SENTENCE))
                .filter(Input::isPositiveNumber)
                .map(Integer::parseInt)
                .toList();
    }

    public Integer ofBonus(List<Integer> nums) {
        isPositiveNumber(input);
        int bonus = Integer.parseInt(input);
        isInRangeNumbers(bonus);
        isInLotto(bonus, nums);
        return bonus;
    }

    private static Boolean isPositiveNumber(String target) {
        if (!target.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(INPUT_POSITIVE_ERROR.getMessage());
        }
        return true;
    }

    private static void isInRangeNumbers(int bonusNum) {
        if (bonusNum < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < bonusNum) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private static void isInLotto(int bonusNum, List<Integer> nums) {
        if (nums.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR.getMessage());
        }
    }
}
