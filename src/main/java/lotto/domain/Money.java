package lotto.domain;

public class Money {

    private Long money;

    private Money(Long money) {
        this.money = money;
    }

    public static Money of(String money) {

        return new Money(Long.parseLong(money));
    }


    public long showCountConvertTo(long currency) {
        return money/currency;
    }


}
