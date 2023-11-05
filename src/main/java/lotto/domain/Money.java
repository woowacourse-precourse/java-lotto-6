package lotto.domain;

record Money(Integer money) {

    Money {
        if (money <= 0)
            throw new IllegalArgumentException(DomainException.PRICE_LESS_THAN_OR_EQUAL_TO_ZERO.getMessage());
        if (money % Constraint.LOTTO_PRICE.getValue() != 0)
            throw new IllegalArgumentException(DomainException.PRICE_NOT_DIVISIBLE_BY_UNIT.getMessage());
    }
}
