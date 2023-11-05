package lotto.dto;

import lotto.domain.PurchasedLotto;

public final class BuyLottoDTO {
    private BuyLottoDTO() {
    }

    public record Input(Long buyPrice) {
    }

    public record Output(PurchasedLotto purchasedLotto) {
    }
}
