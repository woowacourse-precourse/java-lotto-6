package lotto.domain;

import java.util.List;

/**
 * @author 민경수
 * @description lottos
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = List.copyOf(lottoTickets);
    }

    public static LottoTickets of(List<Lotto> lottos) {
        return new LottoTickets(lottos);
    }

    public int size() {
        return lottoTickets.size();
    }
}