package lotto.domain;

import org.junit.platform.commons.util.StringUtils;

public class Money {
    private int money;

    public Money(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        if (StringUtils.isBlank(money)) {
            throw new IllegalArgumentException("[ERROR] - 입력된 값이 공백이거나 null입니다.");
        }

        if (!isDigit(money)) {
            throw new IllegalArgumentException("[ERROR] - 입력된 값은 숫자가 아닙니다.");
        }

        if(Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] - 1,000원 단위로 입력되어야 합니다.");
        }
    }

    private boolean isDigit(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public int getDividedThousandWonCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
