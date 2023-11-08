package lotto.dto;

import lotto.domain.BuyLotto;

public final class BuyLottoDTO {
    private BuyLottoDTO() {
    }

    public static class Input extends DTO.Input {
        private Long buyPrice;

        public Long getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(Long buyPrice) {
            validateOverride(this.buyPrice);
            this.buyPrice = buyPrice;
        }
    }

    public static class Output extends DTO.Output {
        private final BuyLotto buyLotto;

        public Output(BuyLotto buyLotto) {
            this.buyLotto = buyLotto;
        }

        public BuyLotto getBuyLotto() {
            return buyLotto;
        }
    }
}
