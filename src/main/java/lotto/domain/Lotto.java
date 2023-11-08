package lotto.domain;

import lotto.common.LottoFinalConsts;

import java.util.HashSet;
import java.util.List;

public class Lotto implements LottoFinalConsts {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size()!=numbers.size()){
            String errorMessage = LOTTO_ERROR_MESSAGE+LOTTO_HAS_DUPLICATED;
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
