package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public record UserLottos(List<Lotto> lottos) {
    private static final int COUNT_UNIT = 1;
    public LottoResult compareAllLottos(WinningLotto winningLotto) {
        Map<LottoPrizes, Integer> prizesCountMap = LottoPrizes.getPrizesCountMap();

        lottos.stream()
                .map(winningLotto::compare)
                .filter(Objects::nonNull)
                .forEach(prize -> prizesCountMap.merge(prize, COUNT_UNIT, Integer::sum));

        return new LottoResult(prizesCountMap);
    }

    public String displayAllLottos() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public int getTotalLottos() {
        return lottos.size();
    }
}
