package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.ErrorMessage.NOT_DIVISIBLE;
import static lotto.constant.ErrorMessage.NOT_NUMERIC;
import static lotto.constant.LottoSetting.DIVISOR;

import java.util.List;
import java.util.stream.IntStream;
import lotto.service.NumberGenerator;

public class PurchaseCount {
    private final Integer value;

    public PurchaseCount(String purchaseAmountInput) {
        this.value = validatePurchaseAmount(purchaseAmountInput);
    }

    public Integer validatePurchaseAmount(String purchaseAmountInput) {
        Integer purchaseAmount = validateNumeric(purchaseAmountInput);
        return validateDivisible(purchaseAmount);
    }

    private Integer validateNumeric(String purchaseAmountInput) {
        try {
            return Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

    private Integer validateDivisible(Integer purchaseAmount) {
        if (purchaseAmount % DIVISOR.getValue() != 0) {
            throw new IllegalArgumentException(
                    format(NOT_DIVISIBLE.getMessage(), DIVISOR.getValue())
            );
        }
        return purchaseAmount / DIVISOR.getValue();
    }

    public List<Lotto> purchase(NumberGenerator numberGenerator) {
        return IntStream.range(0, value)
                .mapToObj(i -> new Lotto(numberGenerator.generate())).toList();
    }
}
