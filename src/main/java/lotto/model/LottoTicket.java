package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicket {
    
    private final List<Lotto> lottos;

    private LottoTicket(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket create(final Money purchasedLotto) {
        List<Lotto> lottos = IntStream.range(0, purchasedLotto.getNumberOfLotto())
                .mapToObj(LottoIndex -> RandomNumberGenerator.generate())
                .map(Lotto::new)
                .toList();
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
