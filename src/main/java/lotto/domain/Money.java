package lotto.domain;

public class Money {
    private static final Integer LOTTOPRICE = 1000;
    private final int money;

    public Money(Integer money){
        this.money = money;
    }

    // lottos로 옮겨야 함
    public int countMoney(){
        return money / LOTTOPRICE;
    }
}
