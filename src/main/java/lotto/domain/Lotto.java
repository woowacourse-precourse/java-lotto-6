package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.exception.DuplicatedLottoException;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicated(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        HashSet<Integer> lottoNumbers = new HashSet<>(numbers);

        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new DuplicatedLottoException();
        }
    }
}
