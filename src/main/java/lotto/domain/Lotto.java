package lotto.domain;

import java.util.List;
import lotto.dto.LottoResponse;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoResponse generateLottoResponse() {
        return new LottoResponse(numbers);
    }

}
