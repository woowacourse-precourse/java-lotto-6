package lotto.model;

import lotto.constant.LottoRank;

import java.util.List;
import java.util.stream.Collectors;

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

    public LottoRank getRank(WinningNumber winningNumbers) {
        int sameNumberCount = countCommonNumbers(numbers, winningNumbers.getNumbers());
        int bonusNumberCount = 0;

        if (numbers.contains(winningNumbers.getBonusNum())) {
            bonusNumberCount++;
        }

        return findLottoRank(sameNumberCount, bonusNumberCount);
    }

    private int countCommonNumbers(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer number : winningNumbers) {
            if (numbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private LottoRank findLottoRank(int sameNumberCount, int bonusNumberCount) {
        for (LottoRank rank : LottoRank.values()) {
            if ((rank.getMatchedNormalNum() == sameNumberCount)
                    && (rank.getMatchedBonusNum() == bonusNumberCount)) {
                return rank;
            }
        }

        return LottoRank.RANK_OUTSIDE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
