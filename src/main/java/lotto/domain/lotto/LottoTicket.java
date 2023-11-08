package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket of(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
