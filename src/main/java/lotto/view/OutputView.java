package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.utils.LottoGameMessage;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void lottoAmount(final long lottoAmount) {
        System.out.println(lottoAmount + LottoGameMessage.LOTTOS_AMOUNT.message);
    }

    public void showLottos(final List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void prizeResult(Map<Prize, Integer> result) {
        System.out.println("당첨 통계\n" + "---");

        this.prizeWinCount(Prize.FIFTH, result.get(Prize.FIFTH));
        this.prizeWinCount(Prize.FOURTH, result.get(Prize.FOURTH));
        this.prizeWinCount(Prize.THIRD, result.get(Prize.THIRD));
        this.prizeWinCount(Prize.SECOND, result.get(Prize.SECOND));
        this.prizeWinCount(Prize.FIRST, result.get(Prize.FIRST));
    }

    public void profitRate(final String profitRate) {
        System.out.println(LottoGameMessage.PROFIT_RATE.message + profitRate + LottoGameMessage.PERCENT.message);
    }

    public void prizeWinCount(Prize prize, int count) {
        System.out.println(Prize.prizeInfo(prize) + LottoGameMessage.DASH.message
                + count + LottoGameMessage.COUNT.message);
    }

    public void errorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}
