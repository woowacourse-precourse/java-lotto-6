package lotto;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDTO> getLottoDTOs() {
        return lottos.stream()
                .map(LottoDTO::from)
                .toList();
    }

    public void getWinningResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            int countOfMatchingNumber = lotto.countMatchingNumber(winningNumber);
            boolean isBonusIncluded = lotto.contains(bonusNumber);
            Rank rank = Rank.of(countOfMatchingNumber, isBonusIncluded);
        }
    }
}