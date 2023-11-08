package lotto.exception;

import lotto.domain.Amount;

public class OverMaxPurchaseAmountException extends CustomException {
    public OverMaxPurchaseAmountException(Amount maxPurchaseAmount) {
        super("최대 금액 제한을 넘어섰습니다. 최대 금액은 " + maxPurchaseAmount.getDecimalFormatAmount() +"원 입니다.");
    }
}
