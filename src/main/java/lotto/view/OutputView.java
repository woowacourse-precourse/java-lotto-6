package lotto.view;
import static lotto.constant.ViewMessage.*;

import lotto.constant.ViewMessage;
import lotto.domain.Lotto;
import lotto.domain.ResultLotto;

import java.util.List;

public class OutputView {
    public static void printInputPurchaseAmount() {
        printlnViewMessage(INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseLottoCount(int count) {
        System.out.println("\n" + count + PURCHASE_LOTTO_COUNT);
    }

    public static void printLottoTickets(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printInputWinnerNumbers() {
        System.out.println();
        printlnViewMessage(INPUT_WINNING_NUMBERS);
    }

    public static void printInputBonusNumber() {
        System.out.println();
        printlnViewMessage(INPUT_BONUS_NUMBER);
    }

    public static void printMatchLotto(ResultLotto resultLotto) {
        printlnViewMessage(RESULT_LOTTO);
        resultLotto.printResult();
    }

    private static void printlnViewMessage(ViewMessage message) {
        System.out.println(message.toString());
    }
}
