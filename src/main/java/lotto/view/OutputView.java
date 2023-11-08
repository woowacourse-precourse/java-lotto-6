package lotto.view;

import lotto.constant.OutputMessage;
import lotto.constant.WinningValues;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printPurChaseCount(int lottoCount) {
        System.out.printf(OutputMessage.AFTER_INPUTTING_PURCHASE_AMOUNT.getMessage(), lottoCount);
        System.out.println();
    }

    public static void printLottoNumbers(StringBuilder lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printFinalOutput() {
        System.out.println(OutputMessage.OUTPUT_LOTTO_WINNING_STATISTICS.getMessage());
    }

    public static void printFinalResults() {
        for (WinningValues winningvalue : WinningValues.values()) {

        }
    }
}
