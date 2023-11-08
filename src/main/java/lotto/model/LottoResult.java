package lotto.model;

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
            if(matchingCount == 3) {
                rank.addFifthPlace();
            } else if (matchingCount == 4) {
                rank.addFourthPlace();
            } else if (matchingCount == 5) {
                calcurateSecondPlace(i);
            } else if (matchingCount == 6) {
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
