package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningRanks {
    private final List<Lotto> lottos;
    private final WinningNumbers winningNumbers;
    private List<Rank> ranks;

    public WinningRanks(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public void calculateRanks() {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Integer matchingNumbers = lotto.getMatchingNumbers(winningNumbers.getWinningNumber().getNumbers(), winningNumbers.getBonusNumber().getNumber());
            boolean isBonusNumberMatch = lotto.isMatchingWithBonusNumber(winningNumbers.getBonusNumber().getNumber());
            Rank rank = Rank.getRankByMatchingNumbersAndBonus(matchingNumbers, isBonusNumberMatch);
            ranks.add(rank);
        }
        this.ranks = ranks;
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
