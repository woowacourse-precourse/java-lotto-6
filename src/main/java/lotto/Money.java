package lotto;

public class Money {
    private final Integer money;
    private final Integer lottoCount;

    public Money(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = money / 1000;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionList.MONEYUNITEXCEPTION.content());
        }
    }

    public void printLottoCount() {
        System.out.println("\n" + lottoCount + "개를 구입했습니다.");
    }
}
