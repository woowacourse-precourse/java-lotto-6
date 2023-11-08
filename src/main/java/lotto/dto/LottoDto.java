package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoRankings;
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

    public static class Result {
        private final Map<LottoRanking, Integer> result;

        private Result(Map<LottoRanking, Integer> result) {
            this.result = result;
        }

        public static Result from(LottoRankings lottoResult) {
            return new Result(lottoResult.getResult());
        }

        public Map<LottoRanking, Integer> getResult() {
            return Map.copyOf(result);
        }
    }
}
