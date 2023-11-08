package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.Constants.Integers.LOTTO_SIZE;
import static lotto.constants.ErrorMessage.DUPLICATED_NUMBER_EXIST;
import static lotto.constants.ErrorMessage.WRONG_LOTTO_SIZE;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
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

    public MatchingResult match(Lotto winningLotto, LottoNumber bonusNumber) {
        int count = match(winningLotto);
        boolean isBonusCorrect = numbers.contains(bonusNumber);

        return new MatchingResult(count, isBonusCorrect);
    }

    public int match(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter((number) -> winningLotto.contains(number))
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
