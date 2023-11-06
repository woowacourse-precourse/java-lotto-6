package lotto.view;

import static lotto.view.constants.ConstantMessage.RESPONSE_FIFTH;
import static lotto.view.constants.ConstantMessage.RESPONSE_FIRST;
import static lotto.view.constants.ConstantMessage.RESPONSE_FOURTH;
import static lotto.view.constants.ConstantMessage.RESPONSE_HYPHEN_SEPARATOR;
import static lotto.view.constants.ConstantMessage.RESPONSE_PROFIT_RATE;
import static lotto.view.constants.ConstantMessage.RESPONSE_SECOND;
import static lotto.view.constants.ConstantMessage.RESPONSE_THIRD;
import static lotto.view.constants.ConstantMessage.RESPONSE_TICKET_AMOUNT;
import static lotto.view.constants.ConstantMessage.RESPONSE_WINNING_STATISTICS;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constants.ConstantMessage;

public class OutputView {
    public static void responseTickets(int ticketAmount, List<Lotto> tickets) {
        ConstantMessage.printNotice(RESPONSE_TICKET_AMOUNT, ticketAmount);
        printTickets(tickets);
    }

    public static void responseWinningStatics() {
        ConstantMessage.printNotice(RESPONSE_WINNING_STATISTICS);
        ConstantMessage.printNotice(RESPONSE_HYPHEN_SEPARATOR);
        ConstantMessage.printNotice(RESPONSE_FIFTH, 0);
        ConstantMessage.printNotice(RESPONSE_FOURTH, 0);
        ConstantMessage.printNotice(RESPONSE_THIRD, 0);
        ConstantMessage.printNotice(RESPONSE_SECOND, 0);
        ConstantMessage.printNotice(RESPONSE_FIRST, 0);
        ConstantMessage.printNotice(RESPONSE_PROFIT_RATE, 0);
    }

    private static void printTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}
