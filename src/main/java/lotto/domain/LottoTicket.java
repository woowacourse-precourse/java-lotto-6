package lotto.domain;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottoTicket;
    public LottoTicket(List<Lotto> lottoTicket) {
        validate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void validate(List<Lotto> lottoTicket) {

    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
