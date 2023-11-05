package lotto.model;

import lotto.config.LottoConfig;
import lotto.dto.request.PurchaseAmountDto;
import lotto.util.Validator;

public class Money {

    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money from(PurchaseAmountDto purchaseAmountDto) {
        String input = purchaseAmountDto.getAmount();
        int parsedAmount = Validator.validateAndParseInteger(input);
        validatePurchaseAmount(parsedAmount);

        return new Money(parsedAmount);
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LottoConfig.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getAmount() {
        return this.amount;
    }

}
