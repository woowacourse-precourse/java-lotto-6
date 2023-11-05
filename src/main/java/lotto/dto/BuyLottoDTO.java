package lotto.dto;

import lotto.domain.PurchasedLotto;

import java.util.List;

public final class PurchasedLottoDTO {
    private PurchasedLottoDTO() {
    }

    public record Input(Long buyPrice) {
    }

    public record Output(List<Lotto> purchasedLotto) {
    }
}
