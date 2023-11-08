package lotto.domain;

import java.util.List;

import static lotto.configuration.ErrorMessage.*;

public class LottoBoard {
    private final List<Lotto> lottos;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoBoard(Lotto winningLotto,
                      Integer bonusNumber,
                      List<Lotto> lottos) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    private void validate(Lotto winningLotto, Integer bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getLottoNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION);
        }
    }

    public List<Rank> calculateRanks() {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningLotto.getLottoNumbers(), bonusNumber))
                .toList();
    }
}
