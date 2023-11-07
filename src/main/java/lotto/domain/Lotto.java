package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private LottoException lottoException = LottoException.getLottoException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);

    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            lottoException.invalidCount();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if(isDuplication(numbers)){
            lottoException.duplicateNumber();
        }

    }

    private boolean isDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    // TODO: 추가 기능 구현
}
