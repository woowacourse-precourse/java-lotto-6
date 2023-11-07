package ui.validator;

import java.text.MessageFormat;
import lotto.LottoConfig;

public class MoneyValidator {
    private MoneyValidator() {
    }

    public static void verify(int money) {
        if (money % LottoConfig.PRICE != 0) {
            String format = MessageFormat.format("[ERROR] {0}원 단위로 입력해주세요.", LottoConfig.PRICE);
            throw new IllegalArgumentException(format);
        }
    }
}
