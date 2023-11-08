package lotto.dto;

import java.math.BigDecimal;

public record LottoPurchaseDto(
        BigDecimal amount,
        int quantity
) {
}
