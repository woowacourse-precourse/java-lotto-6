package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.utils.Constants;

public class LottoMatcher {

    private final WinningLotto winningLotto;

    public LottoMatcher(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoResult matchLottos(final List<Lotto> userLottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto userLotto : userLottos) {
            MatchCount matchCount = matchLotto(userLotto);
            lottoResult.addResult(matchCount);
        }
        return lottoResult;
    }

    private MatchCount matchLotto(final Lotto userLotto) {
        int matchedCount = getMatchedCount(userLotto);
        if (hasBonusMatch(userLotto, matchedCount)) {
            return MatchCount.FIVE_AND_BONUS_MATCH;
        }
        return findMatchCountByMatchedNumber(matchedCount);
    }

    private int getMatchedCount(final Lotto userLotto) {
        return (int) winningLotto.lotto().getNumbers().stream()
            .filter(userLotto::contains)
            .count();
    }

    private boolean hasBonusMatch(final Lotto userLotto, final int matchedCount) {
        return matchedCount == Constants.BONUS_CHECK_NUMBER && userLotto.contains(
            winningLotto.bonus().bonusNumber());
    }

    private MatchCount findMatchCountByMatchedNumber(final int matchedCount) {
        return Arrays.stream(MatchCount.values())
            .filter(matchCount -> matchCount.getMatchCount() == matchedCount)
            .findFirst()
            .orElseThrow(IllegalStateException::new);
    }

}
