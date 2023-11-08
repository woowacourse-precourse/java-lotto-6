package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("determineRank 함수는")
public class RankTest {
    @Nested
    @DisplayName("correctNumber와 보너스 번호 포함 여부를 입력받으면")
    class input_contains_correctNumber_and_hasBonusNumber {
        @Test
        @DisplayName("정상적으로 등수 출력")
        void returns_rank() {
            assertThat(Rank.determineRank(6,false) == Rank.FIRST).isTrue();
            assertThat(Rank.determineRank(5,true) == Rank.SECOND).isTrue();
            assertThat(Rank.determineRank(5,false) == Rank.THIRD).isTrue();
            assertThat(Rank.determineRank(4,false) == Rank.FOURTH).isTrue();
            assertThat(Rank.determineRank(3,false) == Rank.FIFTH).isTrue();
            assertThat(Rank.determineRank(1,false) == Rank.NO_MATCH).isTrue();
        }
    }
}
