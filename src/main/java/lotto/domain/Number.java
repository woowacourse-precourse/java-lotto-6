package lotto.domain;


public class Number {
    private final Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public Integer getCurValue() {
        return value;
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
