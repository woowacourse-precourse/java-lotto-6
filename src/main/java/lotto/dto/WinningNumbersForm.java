package lotto.dto;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersForm {

    private final List<Integer> numbers;

    public WinningNumbersForm(String[] numbers) {
        this.numbers = validateNumbersFormat(numbers);
    }

    private List<Integer> validateNumbersFormat(String[] input) {
        try {
            return Arrays.stream(input).map(number -> Integer.parseInt(number.trim())).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
