package lotto.exception.purchase;

import lotto.constant.Phrases;
import lotto.exception.CommonException;

public class PurchaseAmountException extends CommonException {
    public void cannotDivideThousand(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException(Phrases.cannotDivisionAmountExceptionPhrase);
        }
    }
}
