package lotto.domain;

import static lotto.domain.LottoStore.LOTTO_PRICE;

import lotto.view.InputView;

public class Money {

    private static final String LOTTO_PRICE_PER_THOUSAND = "[ERROR] 로또 금액은 1000원 단위로 판매할 수 있습니다.";
    private int money = 0;

    public Money(Integer money) {
        validInputMoney(money);
        this.money = money;
    }

    private int validInputMoney(int money) {
        try {
            if (money % LOTTO_PRICE != 0 || money <= 0) {
                throw new IllegalArgumentException(LOTTO_PRICE_PER_THOUSAND);
            }
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validInputMoney(new InputView().askPrice());
        }
    }

    public int getMoney() {
        return money;
    }
}
