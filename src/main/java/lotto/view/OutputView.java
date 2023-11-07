package lotto.view;

import java.util.List;
import lotto.Utils;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningResult;

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
}
