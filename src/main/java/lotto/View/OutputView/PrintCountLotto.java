package lotto.View.OutputView;

import static lotto.View.SystemMessage.RESULT_BUY_LOTTO;

public class PrintCountLotto {

    public static void printCountLotto(int countLotto) {
        getPrintCountLotto(countLotto);
    }

    private static void getPrintCountLotto(int countLotto) {
        System.out.printf(RESULT_BUY_LOTTO.getMessage(), countLotto);
        System.out.println();
    }
}
