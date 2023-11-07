package domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
