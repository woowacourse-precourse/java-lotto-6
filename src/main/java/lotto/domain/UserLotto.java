package lotto.domain;

import static lotto.domain.constant.DomainConstant.NEW_LINE;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.constant.LottoPrizes;

public record UserLotto(List<Lotto> lottos) {
    private static final long COUNT_UNIT = 1L;

    public LottoResult compareAllLotto(WinningLotto winningLotto) {
        Map<LottoPrizes, Long> prizesCountMap = LottoPrizes.getPrizesCountMap();

        // 각 로또를 비교한 뒤, 얻어낸 결과가 당첨이라면 각 당첨의 횟수를 증가시킴
        lottos.stream()
                .map(winningLotto::compare)
                .filter(Objects::nonNull)
                .forEach(prize -> prizesCountMap.merge(prize, COUNT_UNIT, Long::sum));

        return new LottoResult(prizesCountMap);
    }

    public Long getLottoCount() {
        return (long)lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(NEW_LINE));
    }
}
