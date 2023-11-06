package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(int count, LottoGenerator lottoGenerator) {
        this.lottos = generate(count, lottoGenerator);
    }

    private List<Lotto> generate(int count, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
