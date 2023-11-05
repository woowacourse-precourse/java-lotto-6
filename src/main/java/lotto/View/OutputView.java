package lotto.View;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "---";

    public static void printLottoAmount(int purchaseAmount) {

        System.out.println(purchaseAmount + LOTTO_AMOUNT_MESSAGE);
        }

    public static void printPurchasedLottos(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}



