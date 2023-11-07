package lotto;

public enum LottoPrinciples {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LIMIT_NUMBER(6);

    private Integer number;

    private LottoPrinciples(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
