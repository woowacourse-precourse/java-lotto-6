package lotto.Constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MatchTypesTest {

    @DisplayName("알맞은 MatchType 반환하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,0,THREE_MATCH", "4,1,FOUR_MATCH", "5,0,FIVE_MATCH", "5,1,FIVE_MATCH_WITH_BONUS",
            "6,0,SIX_MATCH", "6,1,SIX_MATCH"})
    void 매치타입_반환_테스트(Integer WinningNum, Integer BonusWinningNum, MatchTypes expectedMatchType) {
        MatchTypes matchType = MatchTypes.findMatchType(WinningNum, BonusWinningNum);
        assertThat(matchType).isEqualTo(expectedMatchType);
    }
}
