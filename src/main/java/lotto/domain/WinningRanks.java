package lotto.domain;

import lotto.dto.Lottos;
import lotto.dto.Ranks;
import lotto.dto.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class WinningRanks {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;

    public WinningRanks(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public Ranks calculateRanks() {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = generateRank(lotto);
            ranks.add(rank);
        }
        return new Ranks(ranks);
    }

    private Rank generateRank(Lotto lotto) {
        Integer matchingNumbers = lotto.getMatchingNumbers(winningNumbers.getWinningLotto().getNumbers(), winningNumbers.getBonusNumber().getNumber());
        boolean isBonusNumberMatch = lotto.isMatchingWithBonusNumber(winningNumbers.getBonusNumber().getNumber());
        return Rank.getRankByMatchingNumbersAndBonus(matchingNumbers, isBonusNumberMatch);
    }
}
