package lotto.view;

import lotto.domain.Lotto;
import lotto.util.ConsoleMessage;

import java.util.List;

public class OutputView {
    public static void printLottoTicketNumber(int lottoTicketNumber) {
        System.out.printf(ConsoleMessage.LOTTO_TICKET_NUMBER, lottoTicketNumber);
    }

    public static void printPurchasedLottoTickets(List<Lotto> lottos) {
        StringBuilder purchasedLottoTickets = new StringBuilder();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            purchasedLottoTickets.append('\n').append(numbers.toString());
        }
        System.out.println(purchasedLottoTickets.toString());
    }
}
