package lotto.model;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private int money;

    public Money(String money) {
        this.money = validate(money);
    }

    private int validate(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 가격은 숫자로 입력해주세요.");
        }
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하려면 최소 1000원 이상이 필요합니다.");
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 가격은 1000원입니다. 1000원 단위로 입력해주세요.");
        }
        return money;
    }

    public int calculateLottoCount() {
        return this.money / LOTTO_PRICE;
    }
}
