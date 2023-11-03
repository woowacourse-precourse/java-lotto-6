package exception;

import java.text.DecimalFormat;

public class NotCorrectUnitAmountException extends CustomException {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");
    public NotCorrectUnitAmountException(int unitAmount) {
        super("구입 금액은 " + decimalFormat.format(unitAmount) + "원 단위로 나누어 떨어져야 합니다.");
    }
}
