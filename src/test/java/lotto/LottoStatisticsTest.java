package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStatisticsTest {

    @DisplayName("통계에 맞는 결과를 출력한다.")
    @ParameterizedTest
    @MethodSource("provideLottoResultsForAllPrizes")
    void givenLottoResults_whenCalculatingStatistics_thenCorrectDescriptionIsReturned(
            List<LottoResult> results,
            String expectedDescription) {
        // Given
        LottoStatistics statistics = new LottoStatistics(results);

        // When
        String statisticsDescription = statistics.toString();

        // Then
        assertThat(statisticsDescription).contains(expectedDescription);
    }

    static Stream<Arguments> provideLottoResultsForAllPrizes() {
        return Stream.of(
                Arguments.of(List.of(new LottoResult(3, false)), "3개 일치 (5,000원) - 1개"),
                Arguments.of(List.of(new LottoResult(3, true)), "3개 일치 (5,000원) - 1개"),
                Arguments.of(List.of(new LottoResult(4, false)), "4개 일치 (50,000원) - 1개"),
                Arguments.of(List.of(new LottoResult(4, true)), "4개 일치 (50,000원) - 1개"),
                Arguments.of(List.of(new LottoResult(5, false)), "5개 일치 (1,500,000원) - 1개"),
                Arguments.of(List.of(new LottoResult(5, true)), "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개"),
                Arguments.of(List.of(new LottoResult(6, false)), "6개 일치 (2,000,000,000원) - 1개"),
                Arguments.of(List.of(new LottoResult(6, true)), "6개 일치 (2,000,000,000원) - 1개")
        );
    }
}
