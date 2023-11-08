package lotto.view;

import java.text.DecimalFormat;
import lotto.constant.OutputMessage;

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


    public static void printFinalResults(String message, int hitCount) {
        System.out.printf(message, hitCount);
        System.out.println();
    }

    public static void printFinalProfit(String message, double profit) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.printf(message, df.format(profit));
    }
}
