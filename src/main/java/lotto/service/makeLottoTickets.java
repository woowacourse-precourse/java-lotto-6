package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.dto.Dto;

public class makeLottoTickets {
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
