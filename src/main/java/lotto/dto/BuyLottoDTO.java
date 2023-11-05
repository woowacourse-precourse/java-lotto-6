package lotto.dto;

import lotto.domain.PurchasedLotto;

public final class BuyLottoDTO {
    private BuyLottoDTO() {
    }

    public static class Input extends DTO.Input {
        private Long buyPrice;

        public Long getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(Long buyPrice) {
            this.buyPrice = buyPrice;
        }
    }

    public static class Output extends DTO.Output {
        private final PurchasedLotto purchasedLotto;

        public Output(PurchasedLotto purchasedLotto) {
            this.purchasedLotto = purchasedLotto;
        }

        public PurchasedLotto getPurchasedLotto() {
            return purchasedLotto;
        }
    }
}
