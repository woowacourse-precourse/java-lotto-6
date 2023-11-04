package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        lottoTickets = new ArrayList<>();
        publishLottoTickets(purchaseAmount);
    }

    private void publishLottoTickets(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(createLottoByRandomNumbers());
        }
    }

    private Lotto createLottoByRandomNumbers() {
        return null;
    }
}
