package lotto.vo;

public final class Money {

    private final Integer money;


    public Money(Integer money) {
        this.money = money;
    }

    public boolean isLottoCountSameAsMoney(Integer count) {
        return money.equals(count * 1000);
    }

    public String lottoExchangeCount() {
        return Integer.toString(money / 1000);
    }

    public Integer getMoney() {
        return money;
    }
}
