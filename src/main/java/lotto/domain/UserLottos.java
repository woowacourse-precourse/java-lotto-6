package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public record UserLottos(List<Lotto> lottos) {
    private static final int COUNT_UNIT = 1;
    private static final String NEW_LINE = System.getProperty("line.separator");

    public LottoResult compareAllLottos(WinningLotto winningLotto) {
        Map<LottoPrizes, Integer> prizesCountMap = LottoPrizes.getPrizesCountMap();

        // 각 로또를 비교한 뒤, 얻어낸 결과가 당첨이라면 각 당첨의 횟수를 증가시킴
        lottos.stream()
                .map(winningLotto::compare)
                .filter(Objects::nonNull)
                .forEach(prize -> prizesCountMap.merge(prize, COUNT_UNIT, Integer::sum));

        return new LottoResult(prizesCountMap);
    }

    public String displayAllLottos() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(NEW_LINE));
    }

    public int getTotalLottos() {
        return lottos.size();
    }
}
