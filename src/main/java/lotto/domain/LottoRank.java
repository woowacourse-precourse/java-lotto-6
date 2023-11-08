package lotto.domain;

import static lotto.domain.constant.LottoRankConstant.FIFTH_PRIZE_MONEY;
import static lotto.domain.constant.LottoRankConstant.FIFTH_PRIZE_THRESHOLD;
import static lotto.domain.constant.LottoRankConstant.FIRST_PRIZE_MONEY;
import static lotto.domain.constant.LottoRankConstant.FIRST_PRIZE_THRESHOLD;
import static lotto.domain.constant.LottoRankConstant.FOURTH_PRIZE_MONEY;
import static lotto.domain.constant.LottoRankConstant.FOURTH_PRIZE_THRESHOLD;
import static lotto.domain.constant.LottoRankConstant.NONE_PRIZE_MONEY;
import static lotto.domain.constant.LottoRankConstant.NONE_PRIZE_THRESHOLD;
import static lotto.domain.constant.LottoRankConstant.SECOND_PRIZE_MONEY;
import static lotto.domain.constant.LottoRankConstant.SECOND_PRIZE_THRESHOLD;
import static lotto.domain.constant.LottoRankConstant.THIRD_PRIZE_MONEY;
import static lotto.domain.constant.LottoRankConstant.THIRD_PRIZE_THRESHOLD;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    NONE_PRIZE(NONE_PRIZE_THRESHOLD, NONE_PRIZE_MONEY,
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber < FIFTH_PRIZE_THRESHOLD),
    FIFTH_PRIZE(FIFTH_PRIZE_THRESHOLD, FIFTH_PRIZE_MONEY,
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == FIFTH_PRIZE_THRESHOLD),
    FOURTH_PRIZE(FOURTH_PRIZE_THRESHOLD, FOURTH_PRIZE_MONEY,
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == FOURTH_PRIZE_THRESHOLD),
    THIRD_PRIZE(THIRD_PRIZE_THRESHOLD, THIRD_PRIZE_MONEY,
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == THIRD_PRIZE_THRESHOLD && !containBonusNumber),
    SECOND_PRIZE(SECOND_PRIZE_THRESHOLD, SECOND_PRIZE_MONEY,
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == SECOND_PRIZE_THRESHOLD && containBonusNumber),
    FIRST_PRIZE(FIRST_PRIZE_THRESHOLD, FIRST_PRIZE_MONEY,
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == FIRST_PRIZE_THRESHOLD);

    private final int matchLottoNumber;
    private final int prizeMoney;
    private final BiPredicate<Integer, Boolean> isMatch;

    LottoRank(final int matchLottoNumber, final int prizeMoney, final BiPredicate<Integer, Boolean> isMatch) {
        this.matchLottoNumber = matchLottoNumber;
        this.prizeMoney = prizeMoney;
        this.isMatch = isMatch;
    }

    public static LottoRank getLottoRank(final int matchLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(prize -> prize.isMatch.test(matchLottoNumber, containBonusNumber))
                .findAny()
                .orElse(NONE_PRIZE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }
}
