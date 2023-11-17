package lotto.domain;

import java.text.DecimalFormat;

public enum Prize {
    First(2000000000),
    Second(30000000),
    Third(1500000),
    Fourth(50000),
    Fifth(5000);

    private final int money;
    private final String strMoney;

    Prize(int money) {
        this.money = money;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        strMoney = decimalFormat.format(money);
    }

    public int getMoney() {
        return money;
    }

    public String getStrMoney() {
        return strMoney;
    }
}
