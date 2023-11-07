package lotto.enums;

public enum Constants {

    MIN_INCLUSIVE(1),
    MAX_INCLUSIVE(45),
    LOTTO_NUMBER_SIZE(6),
    ONE_LOTTO_TICKET_PRICE(1000),
    PROFIT_PERCENT(100);

    private final int value;

    Constants(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
