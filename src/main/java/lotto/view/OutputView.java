package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningResult;

import static lotto.common.InfoMessage.*;

import java.util.List;

public class OutputView {

    public void showLotteryTickets(List<Lotto> lotteryTickets ) {
        System.out.printf(PURCHASE_QUANTITY.getMessage(), lotteryTickets.size());
        for (Lotto lotteryTicket : lotteryTickets) {
            System.out.println(lotteryTicket);
        }
    }

    public void showWinningResult(LottoWinningResult lottoWinningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(lottoWinningResult);
    }


    public void showEarningRate(double rate) {
        System.out.println();
        System.out.println(String.format(EARNTING_RATE_OUTPUT.getMessage(), rate));
    }
}
