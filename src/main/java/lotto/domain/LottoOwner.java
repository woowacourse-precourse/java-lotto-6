package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoOwner {
    List<Lotto> lottos;

    public LottoOwner(LottoTicket lottoTicket) {
        lottos = lottoTicket.generateLottos();
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::toString)
                .toList();
    }
}
