package lotto.view;

import lotto.Lotto;
import lotto.message.Message;

import java.util.List;

public class Output {
    public void printEnteringAmountPrompt() {
        System.out.println(Message.PROMPT_ENTERING_PURCHASE_AMOUNT);
    }

    public void printPurchasedLottoTickets(List<Lotto> tickets) {
        System.out.printf((Message.GUIDE_PURCHASED_QUANTITY) + "%n", tickets.size());

        for (Lotto ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void printLottoWinningNumbersPrompt() {
        System.out.println(Message.PROMPT_ENTERING_WINNING_NUMBERS);
    }
}
