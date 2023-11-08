package lotto.view;

import lotto.Lotto;
import lotto.controller.LottoManager;
import lotto.util.Message;

import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoStartMessage() {
        printMessage(Message.START_LOTTO_MESSAGE);
    }

    public static void printInputDangchumMessage() {
        printMessage(Message.INPUT_DANGCHUM_NUM_MESSAGE);
    }

    public static void printInputBonusMessage() {
        printMessage("\n" + Message.INPUT_BONUS_NUM_MESSAGE);
    }

    public static void printLottoAmountMessage(int amount) {
        printMessage("\n" + amount + Message.BUYING_AMOUNT_MESSAGE);
    }

    public static void printLotto(List<Lotto> myLotto) {
        for (Lotto mylotto : myLotto) {
            System.out.println(mylotto.getNumbers());
        }
        printMessage("");
    }

    public static void printCorrectResult() {
        printMessage("\n" + Message.STATISTIC_MESSAGE);
        printMessage(Message.THREE_CORRECT_MESSAGE + LottoManager.getThreeCorrect() + Message.AMOUNT_MESSAGE);
        printMessage(Message.FOUR_CORRECT_MESSAGE + LottoManager.getFourCorrect() + Message.AMOUNT_MESSAGE);
        printMessage(Message.FIVE_CORRECT_MESSAGE + LottoManager.getFiveCorrect() + Message.AMOUNT_MESSAGE);
        printMessage(Message.FIVE_BONUS_CORRECT_MESSAGE + LottoManager.getFiveBonusCorrect() + Message.AMOUNT_MESSAGE);
        printMessage(Message.SIX_CORRECT_MESSAGE + LottoManager.getSixCorrect() + Message.AMOUNT_MESSAGE);
        printMessage(Message.PROFIT_RESULT_MESSAGE_1 + (((double) LottoManager.winningMoney / LottoManager.payMoney) * 1000.0) / 10 + Message.PROFIT_RESULT_MESSAGE_2);
    }

    public static void printDuplicateErrorMessage() {
        printMessage(Message.DUPLICATE_MESSAGE + "\n");
    }

    public static void printInputNotNumberErrorMessage() {
        printMessage(Message.INPUT_NOT_NUMBER_MESSAGE);
    }

    public static void printInputNumRangeErrorMessage() {
        printMessage(Message.INPUT_NUM_RANGE_ERROR_MESSAGE);
    }

    public static void printNumNotSixErrorMessage() {
        printMessage(Message.NUMBER_MUST_SIX);
    }

    public static void printBonusInDangchumErrorMessage() {
        printMessage(Message.BONUS_IN_DANGCHUM);
    }

}
