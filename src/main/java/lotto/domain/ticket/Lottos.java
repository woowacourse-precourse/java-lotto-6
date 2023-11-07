package lotto.domain.ticket;

import lotto.domain.dto.LottoResult;
import lotto.domain.winningnumbers.WinningNumbers;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<LottoResult> checkLottos(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.getResult(winningNumbers))
                .toList();
    }
}
