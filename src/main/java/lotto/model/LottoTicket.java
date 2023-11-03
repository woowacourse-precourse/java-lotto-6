package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

public class LottoTicket {
    
    private final List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket generate(int purchasedLottoNumber) {
        List<Lotto> lottos = IntStream.range(0, purchasedLottoNumber)
                .mapToObj(i -> RandomNumberGenerator.generate())
                .map(Lotto::new)
                .toList();
        return new LottoTicket(lottos);
    }

    public int getLottoSize() {
        return lottos.size();
    }
}
