package lotto;

public class Money {
    private final Integer money;
    private final Integer lottoCount;

    public Money(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = money / Range.UNIT.content(); //발행한 로또 개수 = 구입 금액 / 1000
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
        } //구입 금액 단위(1000)에 맞지 않거나 구입 금액이 0일 경우 에러 처리
    }
}
