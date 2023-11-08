package lotto.domain.lotto;

import static lotto.domain.lotto.LottoCriteria.FIFTH_PLACE;
import static lotto.domain.lotto.LottoCriteria.FIRST_PLACE;
import static lotto.domain.lotto.LottoCriteria.FOURTH_PLACE;
import static lotto.domain.lotto.LottoCriteria.SECOND_PLACE;
import static lotto.domain.lotto.LottoCriteria.THIRD_PLACE;
import static lotto.domain.lotto.LottoCriteria.getAllValues;
import static lotto.domain.lotto.LottoRule.PERCENT;
import static lotto.domain.lotto.LottoRule.PRICE;
import static lotto.util.Utils.getRoundUpTwoDecimalPlace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int INIT_VALUE = 0;
    private static final int INCREMENT = 1;
    private static final long START_VALUE = 0;
    private static final int SHOULD_BONUS_CHECK = 5;

    private final WinningLotto winningLotto;
    private final List<Lotto> issuedLotto;
    private Map<LottoCriteria, Integer> rankingResult;

    public LottoResult(final WinningLotto winningLotto, final List<Lotto> issuedLotto) {
        this.winningLotto = winningLotto;
        this.issuedLotto = issuedLotto;
        initRankingResult();
        saveResult();
    }

    private void initRankingResult() {
        rankingResult = new HashMap<>();

        getAllValues().stream()
                .forEach(rank -> rankingResult.put(rank, INIT_VALUE));
    }

    private void saveResult() {
        issuedLotto.stream().forEach(lotto -> matchingNumber(lotto));
    }

    private void matchingNumber(final Lotto lotto) {
        Long count = getMatchingCount(lotto);

        if (count == FIRST_PLACE.getMatchNumber()) {
            incrementResult(FIRST_PLACE);
        }
        if (count == SHOULD_BONUS_CHECK) {
            bonusCheck(lotto);
        }
        if (count == FOURTH_PLACE.getMatchNumber()) {
            incrementResult(FOURTH_PLACE);
        }
        if (count == FIFTH_PLACE.getMatchNumber()) {
            incrementResult(FIFTH_PLACE);
        }
    }

    private void bonusCheck(Lotto lotto) {
        if (isBonusContain(lotto)) {
            incrementResult(SECOND_PLACE);
            return;
        }
        incrementResult(THIRD_PLACE);
    }

    private Long getMatchingCount(final Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningLotto.lotto().getNumbers()::contains)
                .count();
    }

    private void incrementResult(final LottoCriteria rank) {
        rankingResult.merge(rank, INCREMENT, Integer::sum);
    }

    private boolean isBonusContain(final Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.bonus().getBonusNumber());
    }

    public final float getReturnRate() {
        Long totalAmount = getTotalAmount();
        float returnRate = (float) totalAmount / getInvestMoney() * PERCENT.getValue();

        return getRoundUpTwoDecimalPlace(returnRate);
    }

    private Long getTotalAmount() {
        return getAllValues().stream()
                .map(rank -> rankingResult.get(rank) * rank.getAmount())
                .reduce(START_VALUE, Long::sum);
    }

    private int getInvestMoney() {
        return issuedLotto.size() * PRICE.getValue();
    }

    public final Map<LottoCriteria, Integer> getRankingResult() {
        return rankingResult;
    }
}
