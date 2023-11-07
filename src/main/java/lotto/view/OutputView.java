package lotto.view;

import lotto.Lotto;
import lotto.LottoGameResult;
import lotto.constant.ConsoleMessage;
import lotto.constant.LottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.constant.ConsoleMessage.LOTTO_PROFIT_RATE;
import static lotto.constant.ConsoleMessage.LOTTO_PURCHASE_COMPLETED;

public class OutputView {

//                                    "3개 일치 (5,000원) - 1개",
//                                    "4개 일치 (50,000원) - 0개",
//                                    "5개 일치 (1,500,000원) - 0개",
//                                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
//                                    "6개 일치 (2,000,000,000원) - 0개",
//                                    "총 수익률은 62.5%입니다.";

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
