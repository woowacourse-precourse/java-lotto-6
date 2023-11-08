package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningResult;
import lotto.utils.Utils;

public class OutputView {
    public static void printUserLotto(User user) {
        System.out.println(user.getCount() + "개를 구매했습니다.");

        for (Lotto lotto : user.getLottoList()) {
            List<String> userLottos = Utils.convertIntegerToString(lotto.getNumbers());
            String userLotto = String.join(", ", userLottos);
            System.out.println("[" + userLotto + "]");
        }
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        WinningResult.showResult();
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + (double) Math.round(profit * 10) / 10 + "%입니다.");
    }
}
