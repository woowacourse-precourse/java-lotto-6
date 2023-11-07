package lotto.domain;

import java.util.List;

public class LottoBoard {
    private final List<Lotto> lottos;
    private final Lotto winningLotto;
    private final Integer bonusNumber;

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
            throw new IllegalArgumentException("당첨 번호가 보너스 번호를 포함하고 있습니다.");
        }
    }

    public List<Rank> calculateRanks() {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningLotto.getLottoNumbers(), bonusNumber))
                .toList();
    }
}
