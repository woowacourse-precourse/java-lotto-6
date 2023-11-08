package lotto.dto;

import lotto.domain.BuyLotto;

public final class BuyLottoDto {
    private BuyLottoDto() {
    }

    public static class Input extends InputDto {
        private Long buyPrice;

        public Long getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(Long buyPrice) {
            this.buyPrice = buyPrice;
        }
    }

    public static class Output extends OutputDto {
        private final BuyLotto buyLotto;

        public Output(BuyLotto buyLotto) {
            this.buyLotto = buyLotto;
        }

        public BuyLotto getBuyLotto() {
            return buyLotto;
        }
    }
}
