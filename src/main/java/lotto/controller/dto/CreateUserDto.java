package lotto.controller.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.global.ErrorMessage;

public class CreateUserDto {
    private final long purchaseAmount;
    private final int quantity;
    private List<Lotto> publishedLotto;

    public CreateUserDto(long purchaseAmount) {
        this.purchaseAmount = purchaseAmountValidate(purchaseAmount);
        this.quantity = (int) purchaseAmount / 1000;
    }

    public int getPurchaseAmount() {
        return (int) purchaseAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Lotto> getPublishedLotto() {
        return publishedLotto;
    }

    public void setPublishedLotto(List<Lotto> publishedLotto) {
        this.publishedLotto = publishedLotto;
    }

    private int purchaseAmountValidate(long purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (purchaseAmount > 100000) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_MAXIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_PURCHASE_UNIT.getMessage());
        }
        return (int) purchaseAmount;
    }
}
