package constant;

public enum LottoValue {
    LOTTO_SIZE(6),
    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45),
    AMOUNT_UPPER_LIMIT(2000000000),
    AMOUNT_LOWER_LIMIT(0),
    THOUSAND(1000),
    STATISTICS_THREE_SAME(3),
    STATISTICS_FOUR_SAME(4),
    STATISTICS_FIVE_SAME_WITHOUT_BONUS(5),
    STATISTICS_FIVE_SAME_WITH_BONUS(6),
    STATISTICS_SIX_SAME(7);


    private final int value;

    LottoValue(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }

}
