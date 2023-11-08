package lotto.domain;

import lotto.domain.validator.ValidateBonusBall;

public class BonusBall {
    private final Integer bonusBall;

    public BonusBall(int number, Lotto lotto) {
        validate(number, lotto);
        this.bonusBall = number;
    }

    public void validate(int number, Lotto lotto) {
        ValidateBonusBall.isInRange(number);
        ValidateBonusBall.isDuplicate(number, lotto);
    }

    public int contains(LottoNumber lottoNumber) {
        if (lottoNumber.calculateScore(bonusBall)) {
            return 2;
        }
        return 0;
    }
}
