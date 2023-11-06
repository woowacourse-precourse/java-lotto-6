package lotto.domain;

import static lotto.domain.LottoCriteria.FIFTH_PLACE;
import static lotto.domain.LottoCriteria.FIRST_PLACE;
import static lotto.domain.LottoCriteria.FOURTH_PLACE;
import static lotto.domain.LottoCriteria.SECOND_PLACE;
import static lotto.domain.LottoCriteria.THIRD_PLACE;
import static lotto.domain.LottoRule.PERCENT;
import static lotto.domain.LottoRule.PRICE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final WinningLotto winningLotto;
    private final List<Lotto> issuedLotto;
    private Map<LottoCriteria, Long> rankingResult;

    public LottoResult(final WinningLotto winningLotto, final List<Lotto> issuedLotto) {
        this.winningLotto = winningLotto;
        this.issuedLotto = issuedLotto;
        rankingResult = new HashMap<>();
        rankingResult.put(FIRST_PLACE, 0L);
        rankingResult.put(SECOND_PLACE, 0L);
        rankingResult.put(THIRD_PLACE, 0L);
        rankingResult.put(FOURTH_PLACE, 0L);
        rankingResult.put(FIFTH_PLACE, 0L);
        saveResult();
    }

    private void saveResult() {
        issuedLotto.stream().forEach(lotto -> matchingCount(lotto));
    }

    public void matchingCount(Lotto lotto) {
        Long count = lotto.getNumbers().stream()
                .filter(winningLotto.lotto().getNumbers()::contains)
                .count();
        if (count == FIFTH_PLACE.getCount()) {
            rankingResult.merge(FIFTH_PLACE, 1L, Long::sum);
        }
        if (count == FOURTH_PLACE.getCount()) {
            rankingResult.merge(FOURTH_PLACE, 1L, Long::sum);
        }
        if (count == THIRD_PLACE.getCount() && !isBonusContain(lotto)) {
            rankingResult.merge(THIRD_PLACE, 1L, Long::sum);
        }
        if (count == SECOND_PLACE.getCount() && isBonusContain(lotto)) {
            rankingResult.merge(SECOND_PLACE, 1L, Long::sum);
        }
        if (count == FIRST_PLACE.getCount()) {
            rankingResult.merge(FIRST_PLACE, 1L, Long::sum);
        }
    }

    public boolean isBonusContain(Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.bonus());
    }

    public float getReturnRate() {
        Long totalAmount = rankingResult.get(FIFTH_PLACE) * FIFTH_PLACE.getAmount()
                + rankingResult.get(FOURTH_PLACE) * FOURTH_PLACE.getAmount()
                + rankingResult.get(THIRD_PLACE) * THIRD_PLACE.getAmount()
                + rankingResult.get(SECOND_PLACE) * SECOND_PLACE.getAmount()
                + rankingResult.get(FIRST_PLACE) * FIRST_PLACE.getAmount();
        float returnRate = (float) totalAmount / (issuedLotto.size() * PRICE.getValue()) * PERCENT.getValue();
        Math.round(returnRate);
        return Math.round(returnRate * 100f) / 100f;
    }

    public Map<LottoCriteria, Long> getRankingResult() {
        return rankingResult;
    }
}
