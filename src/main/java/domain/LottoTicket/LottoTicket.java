package domain.LottoTicket;

import lotto.Lotto;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }
}
