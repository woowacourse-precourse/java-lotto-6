package lotto.views;

import lotto.models.Lotto;

import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printPurchaseLottos(int lottoAmount, List<Lotto> lottos) {
        System.out.println(String.format(LOTTO_AMOUNT_MESSAGE, lottoAmount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

}
