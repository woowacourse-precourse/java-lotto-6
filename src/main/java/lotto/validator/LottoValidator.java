package lotto.validator;

import static lotto.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.ErrorMessage.DUPLICATE_WIN_BONUS;
import static lotto.ErrorMessage.OVER_BONUS_NUMBER_BOUNDARY;
import static lotto.ErrorMessage.OVER_LOTTO_BOUNDARY;
import static lotto.ErrorMessage.OVER_LOTTO_SIZE;
import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_END_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_START_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_SIZE;

import java.util.List;
import lotto.view.OutPutView;

public class LottoValidator {

    public static void validateOverSize(List<Integer> numbers) {
        if (!isOverSize(numbers)) {
            throw new IllegalArgumentException(OVER_LOTTO_SIZE.getMessage());
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        if (!isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        if(!isNumbersInRange(numbers)){
            throw new IllegalArgumentException(OVER_LOTTO_BOUNDARY.getMessage());
        }
    }

    public static boolean isBonusInRange(int number) {
        if (number < LOTTO_BOUNDARY_START_NUMBER.get() || number > LOTTO_BOUNDARY_END_NUMBER.get()) {
            OutPutView.println(OVER_BONUS_NUMBER_BOUNDARY.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.stream().anyMatch(num -> num.equals(bonusNumber))) {
            OutPutView.println(DUPLICATE_WIN_BONUS.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isOverSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.get()) {
            OutPutView.println(OVER_LOTTO_SIZE.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isDuplicateNumber(List<Integer> numbers) {
        long distinctListSize = numbers.stream()
                .distinct()
                .count();
        if (distinctListSize != numbers.size()) {
            OutPutView.println(DUPLICATE_LOTTO_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_BOUNDARY_START_NUMBER.get() || number > LOTTO_BOUNDARY_END_NUMBER.get()) {
                OutPutView.println(OVER_LOTTO_BOUNDARY.getMessage());
                return false;
            }
        }
        return true;
    }
}
