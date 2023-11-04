package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        this.lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }
}
