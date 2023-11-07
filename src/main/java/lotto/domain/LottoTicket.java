package lotto.domain;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottoList;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
