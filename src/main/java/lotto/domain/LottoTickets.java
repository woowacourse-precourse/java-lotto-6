package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Lotto, Rank> findRankByLotto(Lotto winningLotto, int bonusNumber) {
        return lottos.stream()
                .collect(Collectors.toMap(
                        lotto -> lotto,
                        lotto -> lotto.findRank(winningLotto, bonusNumber)
                ));
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
