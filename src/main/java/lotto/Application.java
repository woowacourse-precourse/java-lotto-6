package lotto;

import lotto.purchase.Purchase;
import lotto.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int count = Purchase.purchase();

        List<List<Integer>> ticketBundle = LottoTicket.lottoTicket(count);

        LottoTicket.printTickets(ticketBundle);
    }
}
