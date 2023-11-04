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
        System.out.print("[");
        for (int j = 0; j < numbers.size(); j++) {
            if (j == numbers.size() - 1) {
                System.out.println(numbers.get(j) + "]");
                break;
            }
            System.out.print(numbers.get(j) + ", ");
        }
    }

    public static void displayStatistics(List<Integer> lucky, double rate) {
        System.out.println(OutputMessage.LOTTO_STATISTICS.getMessage());
        System.out.println(OutputMessage.LINE_SEPARATOR.getMessage());

        for (int i = 0; i < lucky.size(); i++) {
            System.out.println(String.format(OutputMessage.values()[i + 2].getMessage(), lucky.get(i)));
        }
        System.out.println(String.format(OutputMessage.PROFIT_RATE.getMessage(), rate));
    }
}
