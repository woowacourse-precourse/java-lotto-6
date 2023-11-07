package lotto.domain;


import lotto.exception.MoneyNotTimesOfThousandException;
import lotto.exception.ZeroMoneyException;

public class User { //사용자가 뽑은 로또 리스트들
    private final int ZERO = 0;
    private final int CRITERIA = 1000;
    private final int money;

    public User(int money){
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void validate(int money){
        validateIfZero(money);
        validateIfTimesofThousand(money);
    }

    public void validateIfZero(int money){
        if(money == ZERO){
            throw new ZeroMoneyException();
        }
    }

    public void validateIfTimesofThousand(int money){
        if(money % CRITERIA != 0){
            throw new MoneyNotTimesOfThousandException();
        }
    }

    public int getNumberOfLotto(){
        return money / CRITERIA;
    }
}
