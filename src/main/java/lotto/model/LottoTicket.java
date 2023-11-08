package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Ranking> checkRankings(WinLotto winLotto) {
        return lottos.stream()
                .map(lotto -> lotto.compareWinLotto(winLotto))
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getLottosNumber() {
        return lottos.stream()
                .map(Lotto::getNumberValues)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
