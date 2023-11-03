package lotto.dto;

import lotto.Lotto;
import lotto.Lottos;

import java.util.List;

public class LottoDto {

    public static class Information {
        private final List<Lotto> lottos;

        private Information(List<Lotto> lottos) {
            this.lottos = lottos;
        }

        public static Information from(Lottos lottos) {
            return new Information(lottos.getLottos());
        }

        public List<Lotto> getLottos() {
            return List.copyOf(lottos);
        }
    }
}
