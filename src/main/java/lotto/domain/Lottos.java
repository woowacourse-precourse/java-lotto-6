package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoRank> findLottoRanks(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> findLottoRank(lotto, winningNumbers, bonusNumber))
                .toList();
    }

    private LottoRank findLottoRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = lotto.countMatchedWinningLotto(winningNumbers);
        boolean matchBonus = lotto.isMatchedBonusNumber(bonusNumber);

        return LottoRank.of(matchCount, matchBonus);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
