package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoWinResultService {
    private WinResult winResult = new WinResult();

    public WinResult getWinResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto userLotto : lottos) {
            int sameNumberCount = winningLotto.matchSameNumberCount(userLotto);
            changeWinResultBySameNumberCount(winningLotto, userLotto, sameNumberCount);
        }

        return winResult;
    }

    public String calculateProfitRate(PurchasePrice purchasePrice) {
        String profitRate = new ProfitRate().calculateProfitRate(purchasePrice, winResult);
        return profitRate;
    }

    private void changeWinResultBySameNumberCount(WinningLotto winningLotto, Lotto userLotto, int sameNumberCount) {
        if (winResult.isOverTwo(sameNumberCount)) {
            int rankKey = checkSameNumberCountFiveAndContainBonusNumber(winningLotto, userLotto, sameNumberCount);
            increaseWinResultValueByRankKey(rankKey);
        }
    }

    private int checkSameNumberCountFiveAndContainBonusNumber(WinningLotto winningLotto, Lotto userLotto, int rankKey) {
        if (winResult.isFiveSame(rankKey)) {
            return changeRankKeyByBonusNum(winningLotto, userLotto);
        }
        return rankKey;
    }

    private int changeRankKeyByBonusNum(WinningLotto winningLotto, Lotto userLotto) {
        int rankKey = 5;

        if (winningLotto.isBonusNumContain(userLotto)) {
            rankKey = 7;
        }

        return rankKey;
    }

    private void increaseWinResultValueByRankKey(int rankKey) {
        winResult.increaseWinResultValue(rankKey);
    }
}
