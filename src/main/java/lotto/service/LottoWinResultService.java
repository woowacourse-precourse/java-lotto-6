package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoWinResultService {
    private WinResult winResult = new WinResult();

    public WinResult getWinResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto userLotto : lottos) {
            int rankValue = winningLotto.matchSameNumberNum(userLotto);
            changeWinResultByRankValue(winningLotto, userLotto, rankValue);
        }

        return winResult;
    }

    public double calculateProfitRate(PurchasePrice purchasePrice) {
        double profitRate = new ProfitRate().calculateProfitRate(purchasePrice, winResult);
        return profitRate;
    }

    private void changeWinResultByRankValue(WinningLotto winningLotto, Lotto userLotto, int rankValue) {
        if (winResult.isOverTwo(rankValue)) {
            rankValue = checkSameNumberCountFiveAndContainBonusNumber(winningLotto, userLotto, rankValue);
            increaseWinResultValueByRankValue(rankValue);
        }
    }

    private int checkSameNumberCountFiveAndContainBonusNumber(WinningLotto winningLotto, Lotto userLotto, int rankValue) {
        if (winResult.isFiveSame(rankValue)) {
            return changeRankValueByBonusNum(winningLotto, userLotto);
        }
        return rankValue;
    }

    private int changeRankValueByBonusNum(WinningLotto winningLotto, Lotto userLotto) {
        int rankValue = 5;

        if (winningLotto.isBonusNumContain(userLotto)) {
            rankValue = 7;
        }

        return rankValue;
    }

    private void increaseWinResultValueByRankValue(int rankValue) {
        winResult.increaseWinResultValue(rankValue);
    }
}
