package lotto.dto.request;

import java.util.List;

public class WinningNumbersInputDto {

    private final List<Integer> numbers;

    private WinningNumbersInputDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbersInputDto from(List<Integer> numbers) {
        return new WinningNumbersInputDto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
