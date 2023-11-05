package lotto.domain;

record BonusNumber(Integer bonus, Lotto lotto) {
    BonusNumber {
        validateRange();
        validateDuplication();
    }

    void validateRange() {
        if(bonus < Constraint.MIN.getValue() || bonus > Constraint.MAX.getValue())
            throw new IllegalArgumentException(DomainException.BONUS_RANGE.getMessage());
    }

    void validateDuplication() {
        if(lotto.isContainBonusNumber(bonus))
            throw new IllegalArgumentException(DomainException.BONUS_DUPLICATION.getMessage());
    }
}
