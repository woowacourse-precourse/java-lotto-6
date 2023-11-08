package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RankTest {
    @Nested
    @DisplayName("calculate 메소드 test")
    class CalculateTest {
        @DisplayName("일치하는 개수가 2등 일치개수와 같다면 2등을 반환한다.")
        @Test
        void Matching_count_equals_second_rank() {
            // given
            int matchNumberCount = Rank.SECOND.getMatchNumberCount();
            boolean hasBonusNumber = true;

            // when
            Rank calculatedRank = Rank.calculate(matchNumberCount, hasBonusNumber);

            // then
            assertThat(calculatedRank.getMatchNumberCount()).isEqualTo(matchNumberCount);
        }

        @DisplayName("일치하는 개수에 따른 등수를 반환한다.")
        @Test
        void Matching_count_equals_rank() {
            // given
            int matchNumberCount = Rank.FIRST.getMatchNumberCount();
            boolean hasBonusNumber = false;

            // when
            Rank calculatedRank = Rank.calculate(matchNumberCount, hasBonusNumber);

            // then
            assertThat(calculatedRank.getMatchNumberCount()).isEqualTo(matchNumberCount);
        }
    }
}