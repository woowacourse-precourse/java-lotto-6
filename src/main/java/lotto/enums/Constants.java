package lotto.enums;

public enum Constants {

    MIN_INCLUSIVE(1),
    MAX_INCLUSIVE(45),
    LOTTO_NUMBER_SIZE(6),
    ONE_LOTTO_TICKET_PRICE(1000),
    PROFIT_PERCENT(100),
    RANK_FIVE(5),
    RANK_FOUR(4),
    RANK_THREE(3),
    RANK_TWO(2),
    RANK_ONE(1),
    RANK_FIVE_NUMBER_MATCHES(3),
    RANK_FOUR_NUMBER_MATCHES(4),
    RANK_THREE_NUMBER_MATCHES(5),
    RANK_TWO_NUMBER_MATCHES(5),
    RANK_ONE_NUMBER_MATCHES(6);

    private final int value;

    Constants(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
