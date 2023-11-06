package lotto.domain;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getNumberOfLottos() {
        return lottos.size();
    }
}
