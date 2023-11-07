package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoWinResultService {
    private WinResult winResult = new WinResult();

    public WinResult getWinResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto userLotto : lottos) {
            int sameNumberNum = winningLotto.matchSameNumberNum(userLotto);
            changeWinResultBySameNumberNum(winningLotto, userLotto, sameNumberNum);
        }

        return winResult;
    }

    public String calculateProfitRate(PurchasePrice purchasePrice) {
        String profitRate = new ProfitRate().calculateProfitRate(purchasePrice, winResult);
        return profitRate;
    }

    private void changeWinResultBySameNumberNum(WinningLotto winningLotto, Lotto userLotto, int sameNumberNum) {
        if (winResult.isOverTwo(sameNumberNum)) {
            int rankKey = checkSameNumberCountFiveAndContainBonusNumber(winningLotto, userLotto, sameNumberNum);
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
