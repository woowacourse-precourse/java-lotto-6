package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public final class PurchasedLottoDTO {
    private PurchasedLottoDTO() {
    }

    public static class Input {
        private final Long totalPayPrice;

        public Input(Long totalPayPrice) {
            this.totalPayPrice = totalPayPrice;
        }

        public Long getTotalPayPrice() {
            return totalPayPrice;
        }
    }

    public static class Output {
        private final List<Lotto> purchasedLotto;

        public Output(List<Lotto> purchasedLotto) {
            this.purchasedLotto = purchasedLotto;
        }

        public List<Lotto> getPurchasedLotto() {
            return purchasedLotto;
        }
    }
}
