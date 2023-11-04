package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private final List<Lotto> lottoTickets;

    public LottoFactory(long ticketAcounts) {
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
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

}
