package lotto.View;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.GameMessage;
import lotto.domain.Lotto;

public class OutputView {
    public static void printError(String message) {
        System.out.println(ErrorMessage.ERROR.getMessage() + message);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + GameMessage.BUY_COUNT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
