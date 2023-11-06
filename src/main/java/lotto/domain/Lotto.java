package lotto.domain;

import lotto.util.LottoGameUtil;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(LottoGameMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    public void viewNumberStatus() {
        LottoGameUtil.viewNumberStatus(numbers);
    }
}
