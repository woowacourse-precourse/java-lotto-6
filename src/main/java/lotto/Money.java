package lotto;

public class Money {
    private final Integer money;
    private final Integer lottoCount;

    public Money(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = money / Range.UNIT.content();
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    private void validate(int money) {
        if (money % Range.UNIT.content() != Range.ZERO.content() || money == Range.ZERO.content()) {
            throw new IllegalArgumentException(ExceptionList.MONEYUNITEXCEPTION.content());
        }
    }
}
