package lotto.View;

import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "---";

    public static void printLottoAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + LOTTO_AMOUNT_MESSAGE);
    }

}
