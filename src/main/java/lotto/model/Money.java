package lotto.model;

public class Money {
    private int money;
    public Money(int money) {
        validate();
        this.money = money;
    }
    private void validate(){
        if (money % 1000!= 0){
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
