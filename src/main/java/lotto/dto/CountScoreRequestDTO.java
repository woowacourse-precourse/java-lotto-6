package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class CountScoreRequestDTO {
    private List<Lotto> lottoTickets;
    private Lotto lotto;
    private int bonus;

    private CountScoreRequestDTO() {}

    public static class Builder {
        private List<Lotto> lottoTickets;
        private Lotto lotto;
        private int bonus;

        public Builder lottoTickets(List<Lotto> lottoTickets) {
            this.lottoTickets = lottoTickets;
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

        public CountScoreRequestDTO build() {
            CountScoreRequestDTO countScoreRequestDTO = new CountScoreRequestDTO();
            countScoreRequestDTO.lottoTickets = this.lottoTickets;
            countScoreRequestDTO.lotto = this.lotto;
            countScoreRequestDTO.bonus = this.bonus;
            return countScoreRequestDTO;
        }
    }
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
