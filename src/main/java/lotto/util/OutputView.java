package lotto.util;

import lotto.domain.EarningCalculator;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.message.OutPutMessage;

import java.util.EnumMap;
import java.util.List;

import static lotto.message.OutPutMessage.*;

public class OutputView {
    public void printLotteries(int purchaseAmount, List<Lotto> lotteries) {
        System.out.println(OutPutMessage.OUTPUT_PURCHASE_QUANTITY.format(purchaseAmount));
        for (Lotto lotto : lotteries) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult(EnumMap<LottoRank, Integer> lottoResultMap) {

        System.out.println(OUTPUT_STATISTICS.getMessage());

        for (LottoRank lottoRank : lottoResultMap.keySet()) {
            if (lottoRank == LottoRank.NONE) {
                continue;
            }
            int matches = lottoRank.getMatchedCount();
            int earnings = lottoRank.getEarnings();
            int matchesCount = lottoResultMap.get(lottoRank);
            if (matches == 5 && lottoRank.isMatchesBonusNumber()) {
                System.out.println(OUTPUT_MATCH_COUNT_WITH_BONUS.format(matches, earnings, matchesCount));
            } else {
                System.out.println(OUTPUT_MATCH_COUNT.format(matches, earnings, matchesCount));
            }
        }
    }

    public void printLottoEarningRate(int purchaseAmount, EnumMap<LottoRank, Integer> lottoResultMap) {
        double earningRate = new EarningCalculator().getEarningRate(lottoResultMap, purchaseAmount);
        System.out.println(OutPutMessage.OUTPUT_TOTAL.format(earningRate));
    }

}