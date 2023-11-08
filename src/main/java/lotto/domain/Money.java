package lotto.domain;

public class Money {

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    public long getMoney(){
        return money;
    }

    public int getCount() {
        return (int)money/1000;
    }

    private void validate(long money) {
        if(0 != money%1000){
            throw new IllegalArgumentException("[ERROR] 돈의 단위는 1000원입니다.");
        }
    }


}
