package lotto.formatter;

import lotto.constants.lotto.WinningFactor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 게임 결과 객체에 대해")
class GameResultFormatterTest {

    static Stream<Arguments> statisticsAndTotalRateSource() {
        Map<WinningFactor, Integer> testStatistics = new EnumMap<>(WinningFactor.class);

        Arrays.stream(WinningFactor.values())
                .forEach(winningFactor -> testStatistics.put(winningFactor, 0));
        testStatistics.put(WinningFactor.THREE_MATCH, 1);

        return Stream.of(arguments(testStatistics, 62.5));
    }

    @ParameterizedTest
    @MethodSource("statisticsAndTotalRateSource")
    @DisplayName("3개 일치할 떄의 통계 출력 형태를 얻는다.")
    void Given_CreateGameResultFormatter_When_toStatisticsResultMessage_Then_ExpectedFormat(Map<WinningFactor, Integer> statistics, Double totalRate) {
        //given
        GameResultFormatter gameResultFormatter = new GameResultFormatter(statistics, totalRate);

        //when
        String actual = gameResultFormatter.toStatisticsResultMessage();

        //then
        assertThat(actual).isEqualTo(
                """
                        3개 일치 (5,000원) - 1개
                        4개 일치 (50,000원) - 0개
                        5개 일치 (1,500,000원) - 0개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                        6개 일치 (2,000,000,000원) - 0개"""
        );
    }

    @ParameterizedTest
    @MethodSource("statisticsAndTotalRateSource")
    @DisplayName("최종 수익룰의 출력 형태를 얻는다.")
    void Given_CreateStatisticsAndTotalRate_When_toTotalRateMessage_Then_ExpectedFormat(Map<WinningFactor, Integer> statistics, Double totalRate) {
        //given
        GameResultFormatter gameResultFormatter = new GameResultFormatter(statistics, totalRate);

        //when
        String actual = gameResultFormatter.toTotalRateMessage();

        //then
        assertThat(actual).isEqualTo("총 수익률은 62.5%입니다.");
    }
}
