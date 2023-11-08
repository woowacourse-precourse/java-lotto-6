package lotto.view;

import lotto.message.ConsoleMessage;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoNumber(List<Integer> userNumber) {
        System.out.println(userNumber);
    }


    public static void printWinningStat(List<Integer> winningList) {
        System.out.println(ConsoleMessage.RESULT_LOTTO.getMessage());
        System.out.println("---");

        System.out.printf(ConsoleMessage.CORRECT_NUMBER.getMessage(), 3, "5,000", winningList.get(5));
        System.out.printf(ConsoleMessage.CORRECT_NUMBER.getMessage(), 4, "50,000", winningList.get(4));
        System.out.printf(ConsoleMessage.CORRECT_NUMBER.getMessage(), 5, "1,500,000", winningList.get(3));
        System.out.printf(ConsoleMessage.CORRECT_BONUS_NUMBER.getMessage(), 5, "30,000,000", winningList.get(2));
        System.out.printf(ConsoleMessage.CORRECT_NUMBER.getMessage(), 6, "2,000,000,000", winningList.get(1));
    }

    public static void printRateOfReturn(double rate) {
        System.out.printf(ConsoleMessage.RETURN_RATE.getMessage(), rate);
    }
}
