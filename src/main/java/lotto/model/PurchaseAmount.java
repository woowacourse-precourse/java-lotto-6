package lotto.model;

import lotto.model.enums.LottoSpec;
import lotto.view.enums.ErrorMessage;

public class PurchaseAmount {
    private int purchaseMoney;

    public PurchaseAmount(int purchaseMoney) {
        validate(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validate(int purchaseMoney) {
        validateDivideByPrice(purchaseMoney);
        validateTicketNumberGreaterThanZero(purchaseMoney);
    }

    private void validateDivideByPrice(int money) {
        if (money % LottoSpec.PRICE.getValue() != 0) {
            throw new IllegalStateException(ErrorMessage.CANT_DIVIDE.getMessage());
        }
    }

    private void validateTicketNumberGreaterThanZero(int money) {
        if (money / LottoSpec.PRICE.getValue() <= 0) {
            throw new IllegalStateException(ErrorMessage.TICKET_NUMBER_LESS_THAN_ONE.getMessage());
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getTicketNumber() {
        return purchaseMoney / LottoSpec.PRICE.getValue();
    }
}
