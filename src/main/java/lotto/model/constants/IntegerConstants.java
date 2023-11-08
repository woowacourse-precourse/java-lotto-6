package lotto.model.constants;

public enum IntegerConstants {
    SIZE_OF_LOTTO(6),
    MINIMUM_OF_LOTTO(1),
    MAXIMUM_OF_LOTTO(45),

    ZERO(0), TWO(2),

    FIRST_PRIZE(2_000_000_000), SECOND_PRIZE(30_000_000), THIRD_PRIZE(1_500_000),
    FOURTH_PRIZE(50_000), FIFTH_PRIZE(5_000);
    private final Integer number;

    IntegerConstants(Integer constant) {
        this.number = constant;
    }

    public Integer get(){
        return number;
    }
}
