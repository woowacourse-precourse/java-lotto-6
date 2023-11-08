package lotto.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Rank Enum 테스트")
class RankTest {

    @Nested
    @DisplayName("valueOf 메서드 테스트")
    class ValueOfTests {

        @Test
        @DisplayName("정확한 매치 카운트와 보너스 매치일 때 올바른 등수를 반환한다")
        void whenMatchCountAndBonusMatchCorrect_thenShouldReturnCorrectRank() {
            // 준비 (given)
            long matchCount = 5;
            boolean bonusMatch = true;

            // 실행 (when)
            Rank result = Rank.valueOf(matchCount, bonusMatch);

            // 검증 (then)
            assertThat(result).isEqualTo(Rank.SECOND);
        }

        @Test
        @DisplayName("매치 카운트는 맞지만 보너스 매치가 틀릴 때 다음 낮은 등수를 반환한다")
        void whenMatchCountCorrectButBonusMatchIncorrect_thenShouldReturnNextLowerRank() {
            // 준비 (given)
            long matchCount = 5;
            boolean bonusMatch = false;

            // 실행 (when)
            Rank result = Rank.valueOf(matchCount, bonusMatch);

            // 검증 (then)
            assertThat(result).isEqualTo(Rank.THIRD);
        }

        @Test
        @DisplayName("매치 카운트가 0일 때 NONE을 반환한다")
        void whenMatchCountIsZero_thenShouldReturnNone() {
            // 준비 (given)
            long matchCount = 0;
            boolean bonusMatch = false;

            // 실행 (when)
            Rank result = Rank.valueOf(matchCount, bonusMatch);

            // 검증 (then)
            assertThat(result).isEqualTo(Rank.NONE);
        }

        @Test
        @DisplayName("매치 카운트가 범위를 벗어날 때 NONE을 반환한다")
        void whenMatchCountOutOfBounds_thenShouldReturnNone() {
            // 준비 (given)
            long matchCount = -1;
            boolean bonusMatch = false;

            // 실행 (when)
            Rank result = Rank.valueOf(matchCount, bonusMatch);

            // 검증 (then)
            assertThat(result).isEqualTo(Rank.NONE);
        }
    }
}