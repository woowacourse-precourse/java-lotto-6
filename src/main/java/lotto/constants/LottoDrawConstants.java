package lotto.constants;

public enum LottoDrawConstants {
    FIRST_PRIZE_AMOUNT(2000000000),
    SECOND_PRIZE_AMOUNT(30000000),
    THIRD_PRIZE_AMOUNT(1500000),
    FOURTH_PRIZE_AMOUNT(50000),
    FIFTH_PRIZE_AMOUNT(5000);

    final Integer value;

    LottoDrawConstants(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
