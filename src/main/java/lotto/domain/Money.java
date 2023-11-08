package lotto.domain;

import java.util.regex.Pattern;

public class Money {
    private static final String REGEX = "^[0-9]+$";
    protected static final int DIVISION_FACTOR = 1000;
    private final int money;

    public Money(String money){
        validateReGex(money);
        this.money = Integer.parseInt(money);
        validateLessThanDivisionFactor();
        validateDivision();
    }

    private void validateReGex(String money){
        if(!Pattern.matches(REGEX, money)){
            throw new IllegalArgumentException("[ERROR] 입력 타입이 잘못됬습니다.");
        }
    }

    private void validateLessThanDivisionFactor(){
        if(money < DIVISION_FACTOR){
            throw new IllegalArgumentException("[ERROR] 1000 보다 작은 수가 입력되었습니다.");
        }
    }

    private void validateDivision(){
        if(money%DIVISION_FACTOR != 0){
            throw new IllegalArgumentException("1000원 단위로 입력되지 않았습니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}