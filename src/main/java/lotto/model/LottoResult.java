package lotto.model;

import lotto.model.constant.RankConstants;

import java.util.List;

public class LottoResult {
    private final WinningNumber winningNumber;
    private final Lottos lottos;
    private final BonusNumber bonusNumber;
    private final Rank rank = new Rank();

    public LottoResult(WinningNumber winningNumber, Lottos lottos, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.lottos = lottos;
        this.bonusNumber = bonusNumber;
    }

    public void calcurateLottoRank() {
        List<Integer> matchingCounts = lottos.calcurateLottoCounts(winningNumber);
        for(int i = 0; i < matchingCounts.size(); i++) {
            int matchingCount = matchingCounts.get(i);
            if(matchingCount == RankConstants.RANK_FIFTH.getNumber()) {
                rank.addFifthPlace();
            } else if (matchingCount == RankConstants.RANK_FOURTH.getNumber()) {
                rank.addFourthPlace();
            } else if (matchingCount == RankConstants.RANK_SECOND.getNumber()) {
                calcurateSecondPlace(i);
            } else if (matchingCount == RankConstants.RANK_FIRST.getNumber()) {
                rank.addFirstPlace();
            }
        }
    }

    private void calcurateSecondPlace(int index) {
        if(lottos.isMatchingBonusNumber(index, bonusNumber.getBonusNumber())) {
            rank.addSecondPlace();
            return;
        }
        rank.addThirdPlace();
    }
}
