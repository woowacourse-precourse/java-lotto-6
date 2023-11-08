package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DrawingResultsTest {
    @Nested
    @DisplayName("count 메소드 test")
    class CountTest {
        @DisplayName("일치하는 로또 개수가가 같다면 해당 등수 개수를 증가시킨다.")
        @Test
        void Increasing_the_rank_of_matching_lotto_numbers() {
            // given
            DrawingResults drawingResults = new DrawingResults();

            // when
            drawingResults.count(Rank.FIRST);
            Rank rank = drawingResults.getResults().keySet().stream()
                    .filter(result -> result == Rank.FIRST).findAny().get();
            Integer count = drawingResults.getResults().get(rank);

            // then
            assertThat(count).isEqualTo(1);
        }
    }
}