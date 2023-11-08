package lotto.dto.request;

import java.util.List;

public class WinningNumbersDto {

    private final List<Integer> numbers;

    private WinningNumbersDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbersDto from(List<Integer> numbers) {
        return new WinningNumbersDto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
