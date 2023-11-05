package lotto.domain;

public class Money {

    private long money;

    private Money(Long money) {
        this.money = money;
    }

    public static Money of(String money) {

        return new Money(Long.parseLong(money));
    }

    public long showCountConvertTo(long currency) {
        return money/currency;
    }

    public long showMoney() {
        return money;
    }


}
