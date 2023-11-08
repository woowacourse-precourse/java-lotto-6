package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> convertToRank(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningNumbers, bonusNumber))
                .toList();
    }

}
