package lotto.domain;

import lotto.config.ValidatorConfig;
import lotto.util.Validation;

public class LottoGame {

    private final int bonus;
    private final Lotto winningLotto;


    public LottoGame(int bonus, Lotto winningLotto){
        this.winningLotto = winningLotto;

        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus){
        Validation.validateNumberInRange(bonus);
        if(winningLotto.containBonus(bonus))
            throw new IllegalArgumentException(ValidatorConfig.DUPLICATED_NUMBER_IN_LIST_ERROR.getMessage());
    }
}
