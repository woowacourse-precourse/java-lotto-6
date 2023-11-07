package lotto.domain;

import java.util.List;
import lotto.constants.LottoValues;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Integer lottoNumbersCount = LottoValues.NUMBERS_COUNT.getValue();
        if (numbers.size() != lottoNumbersCount) {
            String errorMessage = String.format("로또 번호 개수는 %d 개 여야 합니다.", lottoNumbersCount);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
