package lotto.model;

public class BuyPrice {
    private final int money;
    public BuyPrice(int money) {
        validate(money);
        this.money = money;
    }
    private void validate(int money) {
        if(money%1000!=0){
            throw new IllegalArgumentException();
        }
    }
    public int getMoney(){
        return money;
    }
}
