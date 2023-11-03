package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoOwner {
    List<Lotto> lottos;
    public LottoOwner(LottoTicket lottoTicket) {
        lottos = lottoTicket.generateLottos();
    }
}
