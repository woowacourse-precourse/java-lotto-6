package view;

import util.OutputMessage;

import java.util.Comparator;
import java.util.List;

public class OutputView {

    public static void printNumOfLotto(int number) {
        System.out.println(number+ OutputMessage.SHOW_AMOUNT_OF_LOTTO.getOutputMessage());
    }

    public static void printLottoTickets(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }

    public static void printResultMessage() {
        System.out.println(OutputMessage.SHOW_TOTAL_RESULT.getOutputMessage());
        System.out.println(OutputMessage.DIVIDER.getOutputMessage());
    }
    public static void printEachLottoResult(String msg, int count) {
        System.out.println(msg + count + "개");
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printRateOfReturn(double rate) {
        System.out.print(OutputMessage.TOTAL_RATE_OF_RETURN.getOutputMessage());
        System.out.print(rate);
        System.out.println(OutputMessage.END_OF_RATE_WORD.getOutputMessage());
    }
}
