package domain;

import java.util.List;
import lotto.Lotto;

public class LottoMachine {
    private int spend;
    private List<Lotto> lottoTickets;

    public LottoMachine(int spend, List<Lotto> lottoTickets) {
        this.spend = spend;
        this.lottoTickets = lottoTickets;
    }

    public int getSpend() {
        return spend;
    }
}
