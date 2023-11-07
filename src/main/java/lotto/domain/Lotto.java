package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lotto.validate.LottoValidate;

public class Lotto {

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidate.lottoNumbersRuleValidate(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    public ScoreBoard matchNumbers(Lotto winnerLotto, Integer winnerBonusNumber) {
        Integer countMatchNumber = checkWinnerBaseNumbers(winnerLotto);
        boolean checkWinnerBonusNumber = numbers.contains(winnerBonusNumber);
        return ScoreBoard.getScoreBoardResultByMatchResult(countMatchNumber,
                checkWinnerBonusNumber);
    }

    public Integer checkWinnerBaseNumbers(Lotto winnerLotto) {
        int countBaseNumber = 0;
        for (Integer number : this.numbers) {
            if (winnerLotto.existNumber(number)) {
                countBaseNumber += 1;
            }
        }
        return countBaseNumber;
    }

    public Boolean existNumber(Integer number) {
        return this.numbers.contains(number);
    }
}
