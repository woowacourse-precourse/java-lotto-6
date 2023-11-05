package lotto.domain.lotto.dto;

import java.util.Arrays;

public record WinningNormalNumberDto(String inputNumbers) {

    public WinningNormalNumberDto {
        if(inputNumbers == null) {
            throw new IllegalArgumentException("null x");
        }
        validateInputNumbers(inputNumbers);
    }

    private void validateInputNumbers(String inputNumbers) {
        String[] numbers = inputNumbers.split(",");
        validateNumbersOfInputNumbersIsSix(numbers);
    }

    private void validateNumbersOfInputNumbersIsSix(String[] numbers) {
        if(numbers.length != 6) {
            throw new IllegalArgumentException("숫자는 6자리 이어야 합니다.");
        }
    }
}
