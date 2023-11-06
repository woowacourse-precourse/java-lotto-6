package lotto.domain.db;


import lotto.constant.Phrases;

import java.util.List;

public class Lotto{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Phrases.wrongSizeExceptionPhrase);
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
