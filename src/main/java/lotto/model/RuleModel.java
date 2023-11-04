package lotto.model;

public enum RuleModel {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    DIGITS(6);

    private final int value;

    RuleModel(int number) {
        this.value = number;
    }

    public int value() {
        return this.value;
    }
}
