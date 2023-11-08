package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;

import static lotto.message.InfoMessage.*;

public class Printer {
    public static void printLineBreak() {
        System.out.println();
    }

    public static void printPurchaseAmountChoiceMessage() {
        System.out.println(PURCHASE_AMOUNT_CHOICE);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.println(lottoCount.getLottoCount() + PURCHASE_COMPLETE);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printWinningNumberChoiceMessage() {
        System.out.println(WINNING_NUMBER_CHOICE);
    }
}
