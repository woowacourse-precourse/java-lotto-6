package lotto.domain;

import lotto.config.ValidatorConfig;
import lotto.util.Validation;

public class LottoGame {

    private final int bonus;
    private final Lotto winningLotto;


    public LottoGame(int bonus, Lotto winningLotto){
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }
}
