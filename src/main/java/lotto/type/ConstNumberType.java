package lotto.type;

public enum ConstNumberType {

    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_SIZE(6);

    private int number;
    ConstNumberType(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
