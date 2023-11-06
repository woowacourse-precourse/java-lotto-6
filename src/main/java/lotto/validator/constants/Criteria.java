package lotto.validator.constants;

public enum Criteria {
    MAX_PAY_AMOUNT(2_000_000_000),
    MAX_NUMBER_DIGIT(10);

    private final int criteria;

    Criteria(int criteria) {
        this.criteria = criteria;
    }

    public int criteria() {
        return criteria;
    }
}
