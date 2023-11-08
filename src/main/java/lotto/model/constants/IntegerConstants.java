package lotto.model.constants;

public enum IntegerConstants {
    SIZE_OF_LOTTO(6),
    ZERO(0), ONE(1), TWO(2);
    private final Integer number;

    IntegerConstants(Integer constant) {
        this.number = constant;
    }

    public Integer get(){
        return number;
    }
}
