package lotto.validation;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;

public class LottoNumberValidator {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int WINNING_NUMBER_SIZE = 6;

    private LottoNumberValidator() {
    }

    public static void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> {
                    if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
                        throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
                    }
                });
    }

    public static void validateLottoNumberDuplication(List<Integer> numbers) {
        int deDuplicatedCount = numbers.stream()
                .collect(Collectors.toSet())
                .size();
        if (numbers.size() != deDuplicatedCount) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATION.getMessage());
        }
    }
}
