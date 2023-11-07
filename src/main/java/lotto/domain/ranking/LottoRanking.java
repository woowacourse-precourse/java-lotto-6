package lotto.domain.ranking;

import static lotto.domain.constant.LottoConstant.LOTTO_NUMBERS_SIZE;
import static lotto.domain.constant.RankingConstant.FIFTH_RANKING_NUMBER_OF_MATCHES;
import static lotto.domain.constant.RankingConstant.FIFTH_RANKING_PRIZE;
import static lotto.domain.constant.RankingConstant.FIRST_RANKING_NUMBER_OF_MATCHES;
import static lotto.domain.constant.RankingConstant.FIRST_RANKING_PRIZE;
import static lotto.domain.constant.RankingConstant.FOURTH_RANKING_NUMBER_OF_MATCHES;
import static lotto.domain.constant.RankingConstant.FOURTH_RANKING_PRIZE;
import static lotto.domain.constant.RankingConstant.SECOND_RANKING_NUMBER_OF_MATCHES;
import static lotto.domain.constant.RankingConstant.SECOND_RANKING_PRIZE;
import static lotto.domain.constant.RankingConstant.THIRD_RANKING_NUMBER_OF_MATCHES;
import static lotto.domain.constant.RankingConstant.THIRD_RANKING_PRIZE;
import static lotto.domain.constant.RankingConstant.UNRANKED_NUMBER_OF_MATCHES_LIMIT;
import static lotto.domain.constant.RankingConstant.UNRANKED_PRIZE;

import java.util.Arrays;
import java.util.function.BiPredicate;
import lotto.domain.money.Money;

public enum LottoRanking {

    FIRST(
        FIRST_RANKING_PRIZE,
        FIRST_RANKING_NUMBER_OF_MATCHES,
        (numberOfMatches, bonusNumberMatches)
            -> numberOfMatches == FIRST_RANKING_NUMBER_OF_MATCHES
    ),
    SECOND(
        SECOND_RANKING_PRIZE,
        SECOND_RANKING_NUMBER_OF_MATCHES,
        (numberOfMatches, bonusNumberMatches)
            -> numberOfMatches == SECOND_RANKING_NUMBER_OF_MATCHES && bonusNumberMatches
    ),
    THIRD(
        THIRD_RANKING_PRIZE,
        THIRD_RANKING_NUMBER_OF_MATCHES,
        (numberOfMatches, bonusNumberMatches)
            -> numberOfMatches == THIRD_RANKING_NUMBER_OF_MATCHES && !bonusNumberMatches
    ),
    FOURTH(
        FOURTH_RANKING_PRIZE,
        FOURTH_RANKING_NUMBER_OF_MATCHES,
        (numberOfMatches, bonusNumberMatches)
            -> numberOfMatches == FOURTH_RANKING_NUMBER_OF_MATCHES
    ),
    FIFTH(
        FIFTH_RANKING_PRIZE,
        FIFTH_RANKING_NUMBER_OF_MATCHES,
        (numberOfMatches, bonusNumberMatches)
            -> numberOfMatches == FIFTH_RANKING_NUMBER_OF_MATCHES
    ),
    UNRANKED(
        UNRANKED_PRIZE,
        UNRANKED_NUMBER_OF_MATCHES_LIMIT,
        (numberOfMatches, bonusNumberMatches)
            -> numberOfMatches <= UNRANKED_NUMBER_OF_MATCHES_LIMIT
    );

    private final Money prize;
    private final int numberOfMatches;
    private final BiPredicate<Integer, Boolean> condition;

    LottoRanking(Money prize, int numberOfMatches, BiPredicate<Integer, Boolean> condition) {
        this.prize = prize;
        this.numberOfMatches = numberOfMatches;
        this.condition = condition;
    }

    public static LottoRanking of(int numberOfMatches, boolean bonusNumberMatches) {
        return Arrays.stream(LottoRanking.values())
            .filter(ranking -> ranking.condition.test(numberOfMatches, bonusNumberMatches))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                String.format("numberOfMatches는 %d를 초과할 수 없습니다.", LOTTO_NUMBERS_SIZE)
            ));
    }

    public int getPrizeValue() {
        return prize.getValue();
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }
}
