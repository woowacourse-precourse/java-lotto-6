package lotto.exception;

import java.util.Set;

public class BuyLottoMoneyFormat extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위로 입력해주세요.";

    public BuyLottoMoneyFormat() {
        super(ERROR_MESSAGE);
    }
}
