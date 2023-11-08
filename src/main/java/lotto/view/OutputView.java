package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningResult;
import lotto.utils.Utils;

public class OutputView {
    private final static String PURCHASE_COUNT_LOTTO = "개를 구매했습니다.";
    private final static String OPEN_BRACKET = "[";
    private final static String CLOSE_BRACKET = "]";
    private final static String WINNING_RESULT = "당첨 통계";
    private final static String TOTAL_PROFIT = "총 수익률은 ";
    private final static String PERCENT = "%입니다.";
    private final static int DO_ROUNDS = 10;

    public static void printUserLotto(User user) {
        System.out.println(user.getCount() + PURCHASE_COUNT_LOTTO);

        for (Lotto lotto : user.getLottoList()) {
            List<String> userLottos = Utils.convertIntegerToString(lotto.getNumbers());
            String userLotto = String.join(", ", userLottos);
            System.out.println(OPEN_BRACKET + userLotto + CLOSE_BRACKET);
        }
    }

    public static void printResult() {
        System.out.println(WINNING_RESULT);
        System.out.println("---");
        WinningResult.showResult();
    }

    public static void printProfit(double profit) {
        System.out.println(TOTAL_PROFIT + (double) Math.round(profit * DO_ROUNDS) / DO_ROUNDS + PERCENT);
    }
}
