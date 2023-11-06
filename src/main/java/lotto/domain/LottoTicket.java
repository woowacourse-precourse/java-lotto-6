package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        validate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }

    public int getLottoCount() {
        return lottoTicket.size();
    }

    private void validate(List<Lotto> lottoTicket) {
        if (lottoTicket == null || lottoTicket.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
