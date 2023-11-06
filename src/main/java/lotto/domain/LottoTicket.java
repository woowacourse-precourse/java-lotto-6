package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoMatchResult> compare(List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.compare(winningNumbers, bonusNumber))
                .toList();
    }
}
