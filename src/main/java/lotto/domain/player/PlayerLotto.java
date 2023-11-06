package lotto.domain.player;

import lotto.domain.player.lotto.Lotto;

public class PlayerLotto {

    private Lotto lottoNubmers;
    private BonusNumber bonusNumber;

    public PlayerLotto(Lotto lottoNubmers, BonusNumber bonusNumber) {
        this.lottoNubmers = lottoNubmers;
        this.bonusNumber = bonusNumber;
    }
}
