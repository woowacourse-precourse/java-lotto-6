package lotto.domain;

import lotto.utils.StringUtils;

public class Amount {
    private final int money;

    public Amount(String money) {
        int m = StringUtils.convertToInt(money);
        this.money = m;
    }
}
