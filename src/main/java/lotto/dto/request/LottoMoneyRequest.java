package lotto.dto.request;

import static lotto.common.ErrorMessages.NOT_A_NUMBER;
import static lotto.common.ErrorMessages.NULL_OR_EMPTY;
import static lotto.utils.StringUtils.isDigit;
import static org.junit.platform.commons.util.StringUtils.isBlank;

import lotto.exception.InputValidationException;

public class LottoMoneyRequest {
    private String money;

    public LottoMoneyRequest(String money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(String money) {
        if (isBlank(money)) {
            throw new InputValidationException(NULL_OR_EMPTY);
        }

        if (!isDigit(money)) {
            throw new InputValidationException(NOT_A_NUMBER, money);
        }
    }

    public String getMoney() {
        return money;
    }
}
