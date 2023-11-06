package lotto.validator;

import static lotto.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.ErrorMessage.OVER_BONUS_NUMBER_BOUNDARY;
import static lotto.ErrorMessage.OVER_LOTTO_BOUNDARY;
import static lotto.ErrorMessage.OVER_LOTTO_SIZE;
import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_END_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_START_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_SIZE;

import java.util.List;

public class LottoValidator {

    public static void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.get()) {
            throw new IllegalArgumentException(OVER_LOTTO_SIZE.getMessage());
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        long distinctListSize = numbers.stream()
                .distinct()
                .count();
        if (distinctListSize != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LOTTO_BOUNDARY_START_NUMBER.get() || number > LOTTO_BOUNDARY_END_NUMBER.get()) {
                throw new IllegalArgumentException(OVER_LOTTO_BOUNDARY.getMessage());
            }
        });
    }

    public static void validateBonusInRange(int number){
        if (number < LOTTO_BOUNDARY_START_NUMBER.get() || number > LOTTO_BOUNDARY_END_NUMBER.get()) {
            throw new IllegalArgumentException(OVER_BONUS_NUMBER_BOUNDARY.getMessage());
        }
    }
}
