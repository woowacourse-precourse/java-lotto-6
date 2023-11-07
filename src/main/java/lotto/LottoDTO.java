package lotto;

import java.util.List;

public class LottoDTO {

    public static LottoDTO from(List<Integer> numbers) {
        return new LottoDTO(numbers);
    }

    private LottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }
}