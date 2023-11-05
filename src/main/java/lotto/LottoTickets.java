package lotto;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(final List<Lotto> lottos) {
        this.lottos = lottos;

    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
