package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<Lotto> lottoTickets;

    public LottoFactory(long ticketAcounts) {
        this.lottoTickets = generate(ticketAcounts);
    }

    public List<Lotto> getTickets() {
        return lottoTickets;
    }

    private List<Lotto> generate(long ticketCounts) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCounts; i++) {
            lottoTickets.add(makeLotto());
        }
        return lottoTickets;
    }

    private Lotto makeLotto() {
        List<Integer> lotto = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT));
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

}
