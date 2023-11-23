package lotto.domain.lotto;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoResult {
    LOSE(0, MatchBonusNumber.IGNORE),
    FIRST(6, MatchBonusNumber.IGNORE),
    SECOND(5, MatchBonusNumber.MATCH),
    THIRD(5, MatchBonusNumber.NOT_MATCH),
    FOURTH(4, MatchBonusNumber.IGNORE),
    FIFTH(3, MatchBonusNumber.IGNORE),
    ;

    private enum MatchBonusNumber {
        MATCH(LottoAnswer::matchesBonusNumber),
        NOT_MATCH(((lottoAnswer, lotto) -> !lottoAnswer.matchesBonusNumber(lotto))),
        IGNORE((lottoAnswer, lotto) -> true),
        ;

        private final BiPredicate<LottoAnswer, Lotto> matchBonusNumber;

        MatchBonusNumber(BiPredicate<LottoAnswer, Lotto> matchBonusNumber) {
            this.matchBonusNumber = matchBonusNumber;
        }

        public boolean checkBonusNumber(LottoAnswer lottoAnswer, Lotto lotto) {
            return this.matchBonusNumber.test(lottoAnswer, lotto);
        }
    }

    private final int sameCount;
    private final MatchBonusNumber matchBonusNumber;

    LottoResult(int sameCount, MatchBonusNumber matchBonusNumber) {
        this.sameCount = sameCount;
        this.matchBonusNumber = matchBonusNumber;
    }

    public static LottoResult getResult(LottoAnswer lottoAnswer, Lotto lotto) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.matchesSameNumberCount(lottoAnswer, lotto))
                .filter(result -> result.checkBonusNumber(lottoAnswer, lotto))
                .findFirst()
                .orElse(LOSE);
    }

    private boolean matchesSameNumberCount(LottoAnswer lottoAnswer, Lotto lotto) {
        int sameNumberCount = lottoAnswer.getSameNumberCount(lotto);
        return this.sameCount == sameNumberCount;
    }

    private boolean checkBonusNumber(LottoAnswer lottoAnswer, Lotto lotto) {
        return this.matchBonusNumber.checkBonusNumber(lottoAnswer, lotto);
    }
}
