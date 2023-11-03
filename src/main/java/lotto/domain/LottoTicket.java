package lotto.domain;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class LottoTicket {
    private static List<Lotto> lottoTickets = new LinkedList<>();

    public static List<Lotto> lottoTickets() {
        return lottoTickets;
    }

    public static void add(Lotto lotto) {
        lottoTickets.add(lotto);
    }
}
