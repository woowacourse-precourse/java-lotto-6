package lotto.model;

import static lotto.validator.Validation.*;

public class LottoMaker { // 입력받은 금액으로 로또 생성
    private final int money;

    public LottoMaker(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        checkEnter(money);
        checkDigit(money);
        checkZero(money);
        checkAvailableDivide(money);
    }

    public int getMoney() {
        return money;
    }

}
