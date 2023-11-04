package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTickets {
    public static final int TICKET_COST = 1000;

    private final List<Lotto> lottoList;

    public LottoTickets() {
         lottoList = new ArrayList<>();
    }

    LottoTickets(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void add(int count) {
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }

    int size() {
        return lottoList.size();
    }
}
