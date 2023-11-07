package dto;

import java.text.MessageFormat;
import lotto.LottoConfig;

public class MoneyDTO {
    private final int money;

    public MoneyDTO(int money) {
        verify(money);
        this.money = money;
    }

    private static void verify(int money) {
        if (money % LottoConfig.PRICE != 0) {
            String format = MessageFormat.format("[ERROR] {0}원 단위로 입력해주세요.", LottoConfig.PRICE);
            throw new IllegalArgumentException(format);
        }
    }

    public int getMoney() {
        return money;
    }
}
