package lotto.view;

import static lotto.view.constant.ViewMessage.OUTPUT_PURCHASE_RESULT;
import static lotto.view.constant.ViewMessage.OUTPUT_RATE_OF_RETURN;
import static lotto.view.constant.ViewMessage.OUTPUT_WINNING_STATISTICS_INTRO;
import static lotto.view.constant.ViewMessage.OUTPUT_WINNING_STATISTICS_RESULT;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.LottoStorage;

public class OutputView {

    public void outputPurchaseResult(LottoStorage lottoStorage, int count) {
        System.out.printf(OUTPUT_PURCHASE_RESULT, count);
        for (Lotto lotto : lottoStorage.getLottoStorage()) {
            System.out.println(lotto);
        }
    }

    public void outputLottoResult(LottoResult result, int money) {
        System.out.print(OUTPUT_WINNING_STATISTICS_INTRO);

        System.out.printf(OUTPUT_WINNING_STATISTICS_RESULT, result.getRankCount(LottoRank.FIFTH),
                result.getRankCount(LottoRank.FOURTH), result.getRankCount(LottoRank.THIRD),
                result.getRankCount(LottoRank.SECOND), result.getRankCount(LottoRank.FIRST));
        System.out.printf(OUTPUT_RATE_OF_RETURN, (float) result.calculatePriceSum() * 100 / money);
    }
}
