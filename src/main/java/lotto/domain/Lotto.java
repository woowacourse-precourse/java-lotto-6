package lotto.domain;

import java.util.List;

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

    public int countCorrectLottoNumbers(Lotto answerLotto) {
        return (int) numbers.stream()
                .filter(answerLotto::contains)
                .count();
    }

    public boolean contains(int lottoNumber) {
        return this.numbers.contains((lottoNumber));
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

}
