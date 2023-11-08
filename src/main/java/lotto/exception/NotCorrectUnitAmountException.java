package lotto.exception;

import lotto.domain.Amount;

public class NotCorrectUnitAmountException extends CustomException {
    public NotCorrectUnitAmountException(Amount unitAmount) {
        super("구입 금액은 " + (unitAmount.getDecimalFormatAmount()) + "원 단위로 나누어 떨어져야 합니다.");
    }
}
