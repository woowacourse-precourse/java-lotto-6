package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public void insertLotto(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
