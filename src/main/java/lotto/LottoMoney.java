package lotto;

import java.text.MessageFormat;

public class LottoMoney {
    private final int money;

    public LottoMoney(int money) {
        verify(money);
        this.money = money;
    }

    private void verify(int money) {
        if (money % LottoConfig.PRICE != 0) {
            String format = MessageFormat.format("[ERROR] {0}원 단위로 입력해주세요.", LottoConfig.PRICE);
            throw new IllegalArgumentException(format);
        }
    }

    public int getAmount() {
        return money / LottoConfig.PRICE;
    }
}
