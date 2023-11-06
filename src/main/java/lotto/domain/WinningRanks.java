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
            Rank rank = generateRank(lotto);
            ranks.add(rank);
        }

        this.ranks = ranks;
    }

    private Rank generateRank(Lotto lotto) {
        Integer matchingNumbers = lotto.getMatchingNumbers(winningNumbers.getWinningNumber().getNumbers(), winningNumbers.getBonusNumber().getNumber());
        boolean isBonusNumberMatch = lotto.isMatchingWithBonusNumber(winningNumbers.getBonusNumber().getNumber());
        return Rank.getRankByMatchingNumbersAndBonus(matchingNumbers, isBonusNumberMatch);
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
