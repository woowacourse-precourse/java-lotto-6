package lotto;

public class Money {
    private final Integer money;
    private final Integer lottoCount;

    public Money(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = money / 1000;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 이루어져야 합니다.");
        }
    }

    public void printLottoCount() {
        System.out.println("\n" + lottoCount + "개를 구입했습니다.");
    }

    public Integer getLottoCount() {
        return lottoCount;
    }
}
