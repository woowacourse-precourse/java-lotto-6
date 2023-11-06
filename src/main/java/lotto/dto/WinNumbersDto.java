package lotto.dto;

import lotto.util.ErrorMessage;

import java.util.List;

public record WinNumbersDto(List<Integer> winNumbers, int bonusNumber) {

    private static final int LOTTO_FIXED_CIPHERS = 6;
    private static final int START_INCLUSIVE_LOTTO_NUMBER = 1;
    private static final int END_INCLUSIVE_LOTTO_NUMBER = 45;

    public WinNumbersDto {
        validate(winNumbers, bonusNumber);
    }

    public void validate(List<Integer> winNumbers, int bonusNumber) {
        validateNumbersSize(winNumbers);
        validateDuplicatedNumbers(winNumbers);
        validateNumbersInRange(winNumbers);
        if (bonusNumber < START_INCLUSIVE_LOTTO_NUMBER || bonusNumber > END_INCLUSIVE_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_FIXED_CIPHERS) {
            throw new IllegalArgumentException(ErrorMessage.UNCORRECT_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.getMessage());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(n -> {
            if (n < START_INCLUSIVE_LOTTO_NUMBER || n > END_INCLUSIVE_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
            }
        });
    }

}
