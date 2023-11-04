package lotto.model;

import lotto.vo.BonusNumber;

public class LottoGame {

    private final Player player;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoGame(final Player player, final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.player = player;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame createGame(final Player player, final Lotto lotto, final BonusNumber bonusNumber) {
        return new LottoGame(player, lotto, bonusNumber);
    }
}
