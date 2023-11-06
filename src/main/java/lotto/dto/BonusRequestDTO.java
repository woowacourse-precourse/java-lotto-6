package lotto.dto;

import lotto.domain.Lotto;

public class BonusRequestDTO {
    private Lotto lotto;
    private String bonus;

    private BonusRequestDTO() {
    }

    public static class Builder {
        private Lotto lotto;
        private String bonus;

        public Builder lotto(Lotto lotto) {
            this.lotto = lotto;
            return this;
        }

        public Builder bonus(String bonus) {
            this.bonus = bonus;
            return this;
        }

        public BonusRequestDTO build() {
            BonusRequestDTO bonusRequestDTO = new BonusRequestDTO();
            bonusRequestDTO.lotto = this.lotto;
            bonusRequestDTO.bonus = this.bonus;
            return bonusRequestDTO;
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public String getBonus() {
        return bonus;
    }
}
