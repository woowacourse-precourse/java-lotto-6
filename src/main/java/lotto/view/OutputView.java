package lotto.view;

import java.util.List;
import lotto.constants.InputMessage;
import lotto.constants.OutputMessage;

public class OutputView {
    public static void printLottoTicketCount(int count) {
        System.out.println();
        System.out.println(count + InputMessage.LOTTO_TICKET_COUNT.getMessage());
    }

    public static void printLottoTickets(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printResult(List<Integer> lucky, double rate) {
        printResultHeader();
        for (int i = 0; i < lucky.size(); i++) {
            System.out.println(String.format(OutputMessage.values()[i + 2].getMessage(), lucky.get(i)));
        }
        System.out.println(String.format(OutputMessage.PROFIT_RATE.getMessage(), rate));
    }

    private static void printResultHeader() {
        System.out.println(OutputMessage.LOTTO_STATISTICS.getMessage());
        System.out.println(OutputMessage.LINE_SEPARATOR.getMessage());
    }
}
