package lotto.model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoPrize.getPrizeRankByMatch;

public class LottoResultModel {
    private final List<LottoPrize> lottoPrizes = new ArrayList<>();
    private final int[] prizeLog = new int[6];

    public List<LottoPrize> getLottoPrizes() {
        return this.lottoPrizes;
    }

    public void checkAllLottoMatch(List<Lotto> purchasedLotto, List<Integer> winNumbers, int bonus) {
        Arrays.fill(prizeLog, 0);
        for (Lotto lotto : purchasedLotto) {
            checkLottoMatch(lotto, winNumbers, bonus);
        }
    }

    private void checkLottoMatch(Lotto lotto, List<Integer> winNumbers, int bonus) {
        int matchCount = 0;
        boolean bonusMatch = false;
        for (int lottoNum : lotto.getLotto()) {
            if (winNumbers.contains(lottoNum)) {
                matchCount += 1;
            }
            if (lottoNum == bonus) {
                bonusMatch = true;
            }
        }
        calcPrizeLog(matchCount, bonusMatch);
    }

    private void calcPrizeLog(int matchCount, boolean bonusMatch) {
        LottoPrize info = getPrizeRankByMatch(matchCount, bonusMatch);
        lottoPrizes.add(info);
        prizeLog[info.getRank()] += 1;
    }

    public int[] getPrizeLog() {
        return this.prizeLog;
    }
}
