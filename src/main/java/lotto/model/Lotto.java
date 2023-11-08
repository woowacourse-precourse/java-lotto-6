package lotto.model;

import static lotto.constant.RankingConstant.SECOND_AND_THIRD_RANKING_REFERENCE_ACCORDED_COUNT;

import java.util.List;
import lotto.validation.LottoValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
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
        if (accordedCount == SECOND_AND_THIRD_RANKING_REFERENCE_ACCORDED_COUNT) {
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
