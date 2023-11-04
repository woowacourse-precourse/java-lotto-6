package lotto.validator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.GameNumberConstants.*;
import static lotto.constants.ValidatorConstants.*;

public class LottoNumberValidator {

    public static void validateBonusNumber(String bonusNumber) {
        Validator.isPrimeNumber(bonusNumber);
        validateNumberRange(Integer.parseInt(bonusNumber));
    }



    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS_TO_MATCH.getValue()) {
            throw new IllegalArgumentException(String.format(
                    LOTTO_INPUT_SHOULD_BE_N.getValue(),
                    NUMBER_OF_NUMBERS_TO_MATCH.getValue())
            );
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        List<Integer> deduplicatedNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (deduplicatedNumbers.size() == numbers.size()) {
            return;
        }
        throw new IllegalArgumentException(SHOULD_NOT_DUPLICATE.getValue());
    }

    public static void validateDuplication(int bonusNumber, List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number.equals(bonusNumber))) {
            throw new IllegalArgumentException(SHOULD_NOT_DUPLICATE.getValue());
        }
    }

    public static void validateNumberRangeInLotto(List<Integer> lotto) {
        lotto.stream()
                .forEach((number) -> validateNumberRange(number));
    }

    public static void validateNumberRange(int number) {
        if ((number < MIN_LOTTO_NUMBER.getValue()) || (number > MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(String.format(
                    SHOULD_BE_IN_LOTTO_NUMBER_RANGE.getValue(),
                    MIN_LOTTO_NUMBER,
                    MAX_LOTTO_NUMBER));
        }
    }
}
