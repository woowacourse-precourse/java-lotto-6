package lotto.domain;

import java.util.List;
import org.w3c.dom.ls.LSOutput;

public class LottoReceipt {
    public List<Lotto> lottoTickets;

    public LottoReceipt(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
