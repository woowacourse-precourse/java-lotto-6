package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Statistic;

public class LottoReader {

    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int matchCount;
    private boolean bonusMatch;

    private Statistic statistic;

    public LottoReader(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        calculateStatistic();
    }

    private void calculateStatistic() throws IllegalArgumentException {
        statistic = new Statistic();
        for (Lotto lotto : lottos) {
            matchCount = 0;
            bonusMatch = false;
            calculateMatch(lotto);
            Integer rank = getRank();
            statistic.addRank(rank);
        }
    }

    public Statistic getStatistic() {
        return statistic;
    }

    private void calculateMatch(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
    }

    public Integer getRank() throws IllegalArgumentException {
        if (matchCount < 3 && matchCount >= 0) {
            return null;
        }
        if (matchCount == 3) {
            return 5;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 5 && !bonusMatch) {
            return 3;
        }
        if (matchCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchCount == 6) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}
