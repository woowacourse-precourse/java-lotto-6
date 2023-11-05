package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public final class PurchasedLottoDTO {
    private PurchasedLottoDTO() {
    }

    public record Input(Long totalPayPrice) {
    }

    public record Output(List<Lotto> purchasedLotto) {
    }
}
