package lotto.utility.enums;

public enum Standards {
    ONE_LOTTO_COST(1000),
    ZERO(0),
    CORRECT_COMMA_COUNT(5),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    COUNT_THREE(3),
    COUNT_FOUR(4),
    COUNT_FIVE(5),
    COUNT_SIX(6),
    THREE_CORRECT_PRIZE(5000),
    FOUR_CORRECT_PRIZE(50000),
    FIVE_CORRECT_PRIZE(1500000),
    FIVE_CORRECT_AND_BONUS_CORRECT_PRIZE(30000000),
    SIX_CORRECT_PRIZE(2000000000);




    private int number;

    Standards(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
