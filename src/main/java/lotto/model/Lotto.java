package lotto.model;

import java.util.Comparator;
import java.util.List;
import lotto.constant.LottoPrize;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoPrize findPrize(WinningNumberAndBonusNumber winningNumberAndBonusNumber) {
        final Integer matchCount = getMatchCount(winningNumberAndBonusNumber.getWinningNumber());
        final Boolean isBonusCorrect = isContains(winningNumberAndBonusNumber.getBonusNumber());

        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.canGetPrize(matchCount, isBonusCorrect)) {
                return prize;
            }
        }

        return LottoPrize.NO_MATCH;
    }

    private Integer getMatchCount(List<Integer> winningNumber) {
        Integer matchCount = 0;
        for (Integer number : winningNumber) {
            if (isContains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private Boolean isContains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
