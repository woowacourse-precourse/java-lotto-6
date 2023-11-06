package lotto.domain;

import java.util.List;

public class LottoGame {
    private final Lotto winnerLotto;
    private final BonusNumber bonusNumber;

    private LottoGame(List<Integer> winnerLotto, BonusNumber bonusNumber) {
        this.winnerLotto = new Lotto(winnerLotto);
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame init(List<Integer> winnerLotto, BonusNumber bonusNumber) {
        return new LottoGame(winnerLotto, bonusNumber);
    }

}
