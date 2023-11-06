package lotto.model;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = sorted(numbers);
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public int getMatchCount(List<Integer> winningLottoNumbers) {
        return (int) numbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
