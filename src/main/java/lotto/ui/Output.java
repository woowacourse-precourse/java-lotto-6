package lotto.ui;

import static lotto.constants.Message.BONUS_NUMBER;
import static lotto.constants.Message.Count;
import static lotto.constants.Message.EARNINGS_RATE;
import static lotto.constants.Message.PURCHASE_LOTTO;
import static lotto.constants.Message.PURCHASE_MONEY;
import static lotto.constants.Message.RESULT;
import static lotto.constants.Message.WINNING_NUMBER;

import java.util.List;
import lotto.constants.Prize;
import lotto.domain.LottoManager;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class Output {

    public static void printError(IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
    }

    public static void printPurchase() {
        System.out.println(PURCHASE_MONEY.getMessage());
    }

    public static void printCount(Integer lottoCount) {
        System.out.println(lottoCount + PURCHASE_LOTTO.getMessage());
    }

    public static void printLottos(List<Lotto> lottos) {
        List<Lotto> sortedLottos = LottoManager.sortLottos(lottos);

        for (Lotto sortedLotto : sortedLottos) {
            System.out.println(sortedLotto.getNumbers());

        }
    }

    public static void printWinningNumber() {
        System.out.println(WINNING_NUMBER.getMessage());
    }

    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER.getMessage());
    }

    public static void printResult(LottoResult lottoResult, Double earningRate) {
        System.out.println(RESULT.getMessage());

        for (Prize prize : lottoResult.state.keySet()) {
            System.out.println(prize.getDescription() + lottoResult.state.get(prize) + Count.getMessage());
        }

        System.out.printf(EARNINGS_RATE.getMessage(), earningRate);
    }
}
