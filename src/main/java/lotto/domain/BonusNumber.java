package lotto.domain;

record BonusNumber(int bonus, Lotto lotto) {
    BonusNumber {
        if(bonus < Constraint.MIN.getValue() || bonus > Constraint.MAX.getValue())
            throw new IllegalArgumentException(DomainException.BONUS_RANGE.getMessage());
        if(lotto.contains(bonus))
            throw new IllegalArgumentException(DomainException.BONUS_DUPLICATION.getMessage());
    }
}
