package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.PriceMoney;

import static lotto.view.constant.viewMessage.*;

public class OutputView {

    public void outputPurchaseLottos(Lottos result, int count) {
        System.out.printf(OUTPUT_PURCHASE_RESULT, count);
        for (Lotto lotto : result.getLottos()) {
            System.out.println(lotto);
        }
    }

    public void outputWinningResult(LottoResult result, Integer money) {
        System.out.print(OUTPUT_WINNING_STATISTICS_INTRO);

        System.out.printf(
                OUTPUT_WINNING_STATISTICS_RESULT
                , result.getRankCount(PriceMoney.FIFTH)
                , result.getRankCount(PriceMoney.FOURTH)
                , result.getRankCount(PriceMoney.THIRD)
                , result.getRankCount(PriceMoney.SECOND)
                , result.getRankCount(PriceMoney.FIRST)
        );
        System.out.printf(OUTPUT_RATE_OF_RETURN,
                (float) result.calculatePrice() * 100 / money);
    }
}
