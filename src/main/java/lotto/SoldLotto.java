package lotto;

import java.util.List;

public class SoldLotto {
    private final List<Lotto> lottoTickets;

    public SoldLotto(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(Lotto::toString)
                .reduce((beforeLotto, lotto) -> beforeLotto + System.lineSeparator() + lotto)
                .get();
    }

    public int getSoldLottoTicketsCount() {
        return lottoTickets.size();
    }
}
