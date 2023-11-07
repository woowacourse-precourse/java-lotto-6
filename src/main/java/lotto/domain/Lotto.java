package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.Constants.Integers.LOTTO_SIZE;
import static lotto.constants.ErrorMessage.DUPLICATED_NUMBER_EXIST;
import static lotto.constants.ErrorMessage.WRONG_LOTTO_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(WRONG_LOTTO_SIZE.getMessage());
        }

        if (isDuplicatedNumberExist(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXIST.getMessage());
        }
    }

    private boolean isDuplicatedNumberExist(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_SIZE.getValue();
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        List<Integer> numbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .toList();

        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
