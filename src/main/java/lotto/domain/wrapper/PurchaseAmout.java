package lotto.domain.wrapper;

import lotto.utils.LottoConstant;
import lotto.utils.ErrorMessage;

public class PurchaseAmout {
    private static final int NO_MONEY = 0;
    private int purchaseAmout;

    public PurchaseAmout(int purchaseAmout) {
        validate(purchaseAmout);
        this.purchaseAmout = purchaseAmout;
    }

    public int getLottoCount() {
        return purchaseAmout / LottoConstant.LOTTO_PRICE.getNumber();
    }

    private void validate(int purchaseAmout) {
        validateMoreThanZero(purchaseAmout);
        validateChangeNoRemaining(purchaseAmout);
    }

    private void validateMoreThanZero(int purchaseAmout) {
        if (purchaseAmout <= NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.NO_MONEY_ERROR.getMessage());
        }
    }

    private void validateChangeNoRemaining(int purchaseAmout) {
        if (purchaseAmout % LottoConstant.LOTTO_PRICE.getNumber() != NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.CHANGE_REMAINED_ERROR.getMessage());
        }
    }
}
