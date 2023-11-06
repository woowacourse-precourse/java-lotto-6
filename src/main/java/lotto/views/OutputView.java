package lotto.views;

import lotto.models.Lotto;
import lotto.models.LottoResult;

import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";

    public static void printPurchaseLottos(int lottoAmount, List<Lotto> lottos) {
        System.out.println(String.format(LOTTO_AMOUNT_MESSAGE, lottoAmount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(lottoResult.toString());
    }

}
