package lotto;

public class Money {

    private final int money;

    public Money(int money){
        validateZero(money);
        validateIsDivision(money);
        this.money = money;
    }

    private void validateZero(int money){
        if(money == 0){
            throw new IllegalArgumentException();
        }
    }

    private void validateIsDivision(int money){
        if(money % 1000 != 0 ){
            throw new IllegalArgumentException();
        }
    }
}
