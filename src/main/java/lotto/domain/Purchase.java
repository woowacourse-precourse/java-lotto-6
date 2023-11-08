package lotto.domain;

import static lotto.constant.ErrorMessage.NOT_DIVIDE;
import static lotto.constant.ErrorMessage.STRANGE_INTEGER;


public class Purchase {

    private final int money;

    public Purchase(int money){
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateNotDivide(money);
        validateUnderZero(money);
    }

    private void validateNotDivide(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE.getMessage());
        }
    }

    private void validateUnderZero(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(STRANGE_INTEGER.getMessage());
        }
    }
    public int getMoney(){
        return money;
    }
}
