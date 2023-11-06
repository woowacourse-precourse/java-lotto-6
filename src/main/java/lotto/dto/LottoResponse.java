package lotto.dto;

import java.util.List;

public class LottoResponse {

    private final List<Integer> numbers;

    public LottoResponse(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
