package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;

public class LottoDto {

    public static class Information {

        private final List<Lotto> lottos;

        private Information(List<Lotto> lottos) {
            this.lottos = lottos;
        }

        public static Information from(Lottos lottos) {
            return new Information(lottos.lottos());
        }

        public List<Lotto> getLottos() {
            return List.copyOf(lottos);
        }
    }

    public record Result(Map<LottoRanking, Integer> result) {

        public static Result from(LottoResult lottoResult) {
            return new Result(lottoResult.getResult());
        }

        @Override
        public Map<LottoRanking, Integer> result() {
            return Map.copyOf(result);
        }
    }
}
