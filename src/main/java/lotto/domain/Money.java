package lotto.domain;

import static lotto.utils.StringUtils.isDigit;
import static org.junit.platform.commons.util.StringUtils.isBlank;

public class Money {
    private int money;

    public Money(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        if (isBlank(money)) {
            throw new IllegalArgumentException("[ERROR] - 입력된 값이 공백이거나 null입니다.");
        }

        if (!isDigit(money)) {
            throw new IllegalArgumentException("[ERROR] - 입력된 값은 숫자가 아닙니다.");
        }

        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] - 1,000원 단위로 입력되어야 합니다.");
        }
    }

    public int getDividedThousandWonCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
