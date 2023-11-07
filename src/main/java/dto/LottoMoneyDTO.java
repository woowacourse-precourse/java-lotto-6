package dto;

import java.text.MessageFormat;
import lotto.LottoConfig;

public class LottoMoneyDTO {
    private final int money;

    public LottoMoneyDTO(int money) {
        if (money % LottoConfig.PRICE != 0) {
            String format = MessageFormat.format("[ERROR] {0}원 단위로 입력해주세요.", LottoConfig.PRICE);
            throw new IllegalArgumentException(format);
        }
        this.money = money;
    }

    public int getAmount() {
        return money / LottoConfig.PRICE;
    }
}
