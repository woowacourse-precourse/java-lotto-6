package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoRequestDTO {
    private Lottos lottos;
    private Lotto lotto;
    private int bonus;

    private LottoRequestDTO() {}

    public static class Builder {
        private Lottos lottos;
        private Lotto lotto;
        private int bonus;

        public Builder lottos(Lottos lottos) {
            this.lottos = lottos;
            return this;
        }

        public Builder numbers(Lotto lotto) {
            this.lotto = lotto;
            return this;
        }

        public Builder bonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public LottoRequestDTO build() {
            LottoRequestDTO lottoRequestDTO = new LottoRequestDTO();
            lottoRequestDTO.lottos = this.lottos;
            lottoRequestDTO.lotto = this.lotto;
            lottoRequestDTO.bonus = this.bonus;
            return lottoRequestDTO;
        }
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
