package lotto.view;

import lotto.Lotto;
import lotto.LottoGameResult;

import java.util.List;

import static lotto.constant.ConsoleMessage.LOTTO_PROFIT_RATE;
import static lotto.constant.ConsoleMessage.LOTTO_PURCHASE_COMPLETED;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf((LOTTO_PURCHASE_COMPLETED), lottos.size());

        lottos.forEach(System.out::println);
    }

    public void printLottoResult(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(lottoGameResult);


    }
    public void printProfitRate(double profitRate) {
        System.out.println(String.format(LOTTO_PROFIT_RATE, profitRate));
    }
}
