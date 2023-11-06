package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class MakeLottoTickets {
    private static List<String> lottoTickets = new ArrayList<>();
    public static List<String> make(List<Lotto> tickets) {
        add(tickets);

        return lottoTickets;
    }

    private static void add(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            lottoTickets.add(ticket.getNumbers().toString());
        }
    }
}
