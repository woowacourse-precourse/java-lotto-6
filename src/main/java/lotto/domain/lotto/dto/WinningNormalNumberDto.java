package lotto.domain.lotto.dto;

import static lotto.global.constant.NumberDefinition.LOTTO_NUMBER_COUNT;
import static lotto.global.constant.exception.ExceptionMessage.INPUT_CANNOT_BE_NULL;
import static lotto.global.constant.exception.ExceptionMessage.NUMBERS_COUNT_MUST_BE_SIX;

public record WinningNormalNumberDto(String numbers) {
    private static final String SEPARATOR = ",";

    public WinningNormalNumberDto {
        if(numbers == null) {
            throw new IllegalArgumentException(INPUT_CANNOT_BE_NULL.getMessage());
        }
        validateInputNumbers(numbers);
    }

    private void validateInputNumbers(String inputNumbers) {
        String[] numbers = inputNumbers.split(SEPARATOR);
        validateNumbersOfInputNumbersIsSix(numbers);
    }

    private void validateNumbersOfInputNumbersIsSix(String[] numbers) {
        if(numbers.length != LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(NUMBERS_COUNT_MUST_BE_SIX.getMessage());
        }
    }
}
