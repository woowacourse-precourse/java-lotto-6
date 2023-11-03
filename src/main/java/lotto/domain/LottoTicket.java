package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTickets;

    public LottoTicket() {
        this.lottoTickets = new ArrayList<>();
    }

    public LottoTicket buy(int amount) {
        int numberOfLotto = amount / 1_000;

        for (int i = 0; i < numberOfLotto; i++) {
            lottoTickets.add(generateRandomLotto());
        }

        return this;
    }

    private Lotto generateRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}