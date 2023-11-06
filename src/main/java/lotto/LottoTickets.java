package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public void buy(int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoTickets.add(new Lotto(generate()));
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    private List<Integer> generate() {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        final int NUMBER_COUNT = 6;

        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
}
