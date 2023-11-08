package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.validation.LottoValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidation lottoValidation = new LottoValidation();
        lottoValidation.validateLottoNumber(numbers);
    }

    // TODO: 추가 기능 구현
    public Ranking getRanking(List<Integer> winningNumbers, int bonusNumber) {
        int accordedCount = findAccordedNumberCount(winningNumbers);
        boolean hasBonusNumber = false;
        if (accordedCount == 5) {
            hasBonusNumber = hasBonusNumber(bonusNumber);
        }
        return Ranking.getRanking(accordedCount, hasBonusNumber);
    }

    private int findAccordedNumberCount(List<Integer> winningNumbers) {
        return Math.toIntExact(numbers.stream().filter(winningNumbers::contains).count());
    }

    private boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
