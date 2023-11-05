package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoMaker;

public class LottoFactory {
    private final LottoMaker lottoMaker;
    private final List<Lotto> lottoTickets;

    public LottoFactory(LottoMaker lottoMaker, long ticketAcounts) {
        this.lottoMaker = lottoMaker;
        this.lottoTickets = generate(ticketAcounts);
    }

    public List<Lotto> getTickets() {
        return lottoTickets;
    }

    private List<Lotto> generate(long ticketAcounts) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketAcounts; i++) {
            lottoTickets.add(makeLotto());
        }
        return lottoTickets;
    }

    private Lotto makeLotto() {
        List<Integer> lotto = new ArrayList<>(lottoMaker.genrate());
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

}
