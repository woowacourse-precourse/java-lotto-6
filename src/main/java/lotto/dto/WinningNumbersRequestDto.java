package lotto.dto;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersRequestDto {

    private final List<Integer> numbers;

    public WinningNumbersRequestDto(String numbers) {
        this.numbers = validateNumbersFormat(numbers);
    }

    private List<Integer> validateNumbersFormat(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
