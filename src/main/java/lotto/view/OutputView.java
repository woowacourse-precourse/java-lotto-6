package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.view.message.LottoGameMessage;

import java.util.List;
import java.util.Map;

import static lotto.domain.Prize.SECOND;

public class OutputView {

    public void lottoAmount(final long lottoAmount) {
        System.out.println(lottoAmount + LottoGameMessage.LOTTOS_AMOUNT.message);
    }

    public void showLottos(final List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void prizeResult(Map<Prize, Integer> result) {
        System.out.println("당첨 통계\n" + "---");

        prizeWinCount(Prize.FIFTH, result.get(Prize.FIFTH));
        prizeWinCount(Prize.FOURTH, result.get(Prize.FOURTH));
        prizeWinCount(Prize.THIRD, result.get(Prize.THIRD));
        prizeWinCount(SECOND, result.get(SECOND));
        prizeWinCount(Prize.FIRST, result.get(Prize.FIRST));
    }

    public void prizeWinCount(Prize prize, int count) {
        System.out.println(prizeInfo(prize) + LottoGameMessage.DASH.message
                + count + LottoGameMessage.COUNT.message);
    }

    public String prizeInfo(Prize prize) {
        if (prize == SECOND) {
            return prize.matches + "개 일치, 보너스 볼 일치 " + "(" + prize.price+ ")";
        }
        return prize.matches + "개 일치 " + "(" + prize.price + ")";
    }

    public void profitRate(final String profitRate) {
        System.out.println(LottoGameMessage.PROFIT_RATE.message + profitRate + LottoGameMessage.PERCENT.message);
    }

    public void exceptionMessage(final IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
