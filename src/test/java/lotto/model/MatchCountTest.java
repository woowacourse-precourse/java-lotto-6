package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import lotto.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MatchCountTest {

    private final String thousandSeparatorRegex = "^(\\d{1,3})(,\\d{3})*$";

    private final Map<MatchCount, Integer> expectedRewards = Map.of(
        MatchCount.ZERO_MATCH, Constants.NON_REWARD,
        MatchCount.ONE_MATCH, Constants.NON_REWARD,
        MatchCount.TWO_MATCH, Constants.NON_REWARD,
        MatchCount.THREE_MATCH, Constants.FIFTH_PRIZE_MONEY,
        MatchCount.FOUR_MATCH, Constants.FOURTH_PRIZE_MONEY,
        MatchCount.FIVE_MATCH, Constants.THIRD_PRIZE_MONEY,
        MatchCount.FIVE_AND_BONUS_MATCH, Constants.SECOND_PRIZE_MONEY,
        MatchCount.SIX_MATCH, Constants.FIRST_PRIZE_MONEY
    );

    @DisplayName("매칭 카운트가 0에서 6 사이에 있는지 확인")
    @ParameterizedTest
    @EnumSource(MatchCount.class)
    void getMatchCountIsCorrect(MatchCount matchCount) {
        assertThat(matchCount.getMatchCount()).isBetween(0, 6);
    }

    @DisplayName("보너스 매칭 여부는 matchCount가 5개인 경우만 존재하는지 확인")
    @ParameterizedTest
    @EnumSource(MatchCount.class)
    void getBonusMatchingIsCorrect(MatchCount matchCount) {
        boolean expectedBonusMatching = matchCount == MatchCount.FIVE_AND_BONUS_MATCH;
        assertThat(matchCount.isBonusMatching())
            .isEqualTo(expectedBonusMatching);
    }

    @DisplayName("reward가 올바르게 가지고 있는지 확인")
    @ParameterizedTest
    @EnumSource(MatchCount.class)
    void getRewardIsCorrect(MatchCount matchCount) {
        int expectedReward = expectedRewards.get(matchCount);
        assertThat(matchCount.getReward()).isEqualTo(expectedReward);
    }

    @DisplayName("보상을 1000단위로 ,를 붙여 반환하는지 확인")
    @ParameterizedTest
    @EnumSource(MatchCount.class)
    void getFormattedRewardByValidThousandSeparator(MatchCount matchCount) {
        String formattedReward = matchCount.getFormattedReward();
        assertThat(formattedReward).matches(thousandSeparatorRegex);
    }


}