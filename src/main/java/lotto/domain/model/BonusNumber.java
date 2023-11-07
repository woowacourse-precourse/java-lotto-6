package lotto.domain.model;

import lotto.domain.constant.Constraint;
import lotto.domain.constant.DomainException;

public record BonusNumber(int bonus, Lotto lotto) {
    public BonusNumber {
        if(bonus < Constraint.MIN.getValue() || bonus > Constraint.MAX.getValue())
            throw new IllegalArgumentException(DomainException.BONUS_RANGE.getMessage());
        if(lotto.contains(bonus))
            throw new IllegalArgumentException(DomainException.BONUS_DUPLICATION.getMessage());
    }
}
