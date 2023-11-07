package lotto.exception.money;

import lotto.exception.common.CustomArgumentException;

public class MoneyPositiveException extends CustomArgumentException {
    private static final String MESSAGE = "화폐는 0원 이상의 금액을 가져야 합니다.";

    public MoneyPositiveException() {
        super(MESSAGE);
    }
}
