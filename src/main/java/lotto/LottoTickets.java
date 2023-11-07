package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets implements Iterable<Lotto> {

    private final List<Lotto> lottoTickets = new ArrayList<>();

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets.addAll(lottoTickets);
    }

    public static LottoTickets of(List<Lotto> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<LottoRank> match(WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoTickets.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoTickets.iterator();
    }

    @Override
    public String toString() {
        return lottoTickets.toString();
    }
}
