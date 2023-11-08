package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class Judgement {
    public Ranking compare(LottoWinningNumber lottoWinningNumber, Lotto lotto) {
        List<Integer> winningNumbers = lottoWinningNumber.getWinningNumbers();
        List<Integer> pickNumbers = lotto.getNumbers();
        int count = matchCount(winningNumbers, pickNumbers);
        if (count == 6) {
            return Ranking.FIRST;
        }
        if (count == 5 && pickNumbers.contains(lottoWinningNumber.getBonusNumber())) {
            return Ranking.SECOND;
        }
        if (count == 5) {
            return Ranking.THIRD;
        }
        if (count == 4) {
            return Ranking.FOURTH;
        }
        if (count == 3) {
            return Ranking.FIFTH;
        }
        return Ranking.NONE;
    }

    public int matchCount(List<Integer> winningNumbers, List<Integer> pickNumbers) {
        int count = winningNumbers.stream()
                .filter(pickNumbers::contains)
                .mapToInt(i -> 1)
                .sum();
        return count;
    }
}
