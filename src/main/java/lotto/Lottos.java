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

    public WinningResult getWinningResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            int countOfMatchingNumber = lotto.countMatchingNumber(winningNumber);
            boolean isBonusIncluded = lotto.contains(bonusNumber);

            Rank rank = Rank.of(countOfMatchingNumber, isBonusIncluded);
            winningResult.updateResult(rank);
        }
        return winningResult;
    }
}