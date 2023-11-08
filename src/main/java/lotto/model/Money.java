package lotto.model;

public enum Money {
    THREE(5000, 0),
    FOUR(50000, 1),
    FIVE(1500000, 2),
    FIVE_AND_BONUS(30000000, 3),
    SIX(2000000000, 4);


    private final int money;
    private final int value;
    private Money(int money, int value){
        this.money = money;
        this.value = value;
    }

    public int getMoney(){
        return this.money;
    }

    public int getValue(){
        return this.value;
    }
}
