package lotto.domain.mapper;

import lotto.domain.PurchaseAmount;
import lotto.domain.dto.PurchaseAmountDto;

public class PurchaseAmountMapper {
    private final PurchaseAmountDto purchaseAmountDto;

    public PurchaseAmountMapper(PurchaseAmountDto purchaseAmountDto) {
        this.purchaseAmountDto = purchaseAmountDto;
    }

    public PurchaseAmount from(final PurchaseAmountDto purchaseAmountDto) {
        return new PurchaseAmount(purchaseAmountDto.amount());
    }
}
