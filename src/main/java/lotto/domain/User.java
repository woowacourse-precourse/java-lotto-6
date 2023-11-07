package lotto.domain;


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

    public void validate(int inputValue){
        validateIfZero(inputValue);
        validateIfTimesofThousand(inputValue);
    }

    public void validateIfZero(int inputValue){
        if(inputValue == ZERO){
            throw new IllegalArgumentException();
        }
    }

    public void validateIfTimesofThousand(int inputValue){
        if(inputValue % CRITERIA != 0){
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfLotto(){
        return money / CRITERIA;
    }
}
