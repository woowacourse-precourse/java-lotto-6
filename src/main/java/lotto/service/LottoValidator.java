package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public class LottoValidator {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateBonusRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LottoError.LOTTO_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateBonusDuplicated(List<Lotto> numbers, int bonusNumber) {
        if (numbers.stream().anyMatch(lotto -> lotto.isContain(bonusNumber))) {
            throw new IllegalArgumentException(LottoError.LOTTO_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static int validateBonus(List<Lotto> numbers, int bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicated(numbers, bonusNumber);
        return bonusNumber;
    }

    public static void validateBonus(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.LOTTO_INPUT_FAILED_NUMBER.getMessage());
        }
    }





}
