package lotto.model.dto;

import java.util.List;

public class LottoPaper {
    private final List<Integer> numbers;

    public LottoPaper(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
