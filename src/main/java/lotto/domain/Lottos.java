package lotto.domain;

import java.util.List;
import lotto.LottoDTO;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDTO> getLottoDTOs() {
        return lottos.stream()
                .map(Lotto::getLottoDTO)
                .toList();
    }

    public WinningResult getWinningResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningResult winningResult = new WinningResult();

        lottos.forEach(lotto ->
                {
                    int countMatchingNumber = lotto.countMatchingNumber(winningNumber);
                    boolean isBonusIncluded = lotto.contains(bonusNumber);
                    Rank rank = Rank.of(countMatchingNumber, isBonusIncluded);
                    winningResult.updateResult(rank);
                }
        );
        return winningResult;
    }
}