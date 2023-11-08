package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public long getMoney(){
        return money;
    }

    public int getCount() {
        return money/LOTTO_PRICE;
    }

    private void validate(int money) {
        validateMoneyDevided(money);
        validateMoneyMinimum(money);
    }

    private void validateMoneyMinimum(int money){
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException("[ERROR] 돈은 최소 1000원입니다.");
        }
    }

    private void validateMoneyDevided(int money){
        if(0 != money % LOTTO_PRICE){
            throw new IllegalArgumentException("[ERROR] 돈의 단위는 1000원입니다.");
        }
    }


}
