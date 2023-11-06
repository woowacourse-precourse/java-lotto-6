package lotto.domain;

import lotto.exception.DuplicatedBonusBallException;

public class AnswerLottos {
    private final Lotto lotto;
    private final BonusBall bonusBall;

    public AnswerLottos(Lotto lotto, BonusBall bonusBall) {
        validate(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validate(Lotto lotto, BonusBall bonusBall) {
        if (lotto.isContain(bonusBall.getBall())) {
            throw new DuplicatedBonusBallException();
        }
    }
}
