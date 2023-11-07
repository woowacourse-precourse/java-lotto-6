package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

    @DisplayName("일치하는 개수에 따라 등수 반환")
    @ParameterizedTest
    @MethodSource("parameterProvider")
    void matchPrize(long matchWinningNumber, long matchBonusNumber, String expected) {
        //given
        Prize prize;

        //when
        prize = Prize.matchPrize(matchWinningNumber, matchBonusNumber);

        //then
        assertThat(prize.name()).isEqualTo(expected);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(6, 0, "FIRST"),
                Arguments.arguments(5, 1, "SECOND"),
                Arguments.arguments(5, 0, "THIRD"),
                Arguments.arguments(4, 0, "FOURTH"),
                Arguments.arguments(3, 1, "FIFTH")
        );
    }

    @DisplayName("수익률 계산")
    @Test
    void earningRateCalculator() {
        //given
        List<Long> matchWinningNumber = new ArrayList<>();
        List<Long> matchBonusNumber = new ArrayList<>();
        int purchase = 1000;

        //when
        matchWinningNumber.add(5L);
        matchBonusNumber.add(1L);

        //then
        assertThat(Prize.earningRateCalculator(matchWinningNumber, matchBonusNumber, purchase)).isEqualTo("3000000.0");
    }

    @DisplayName("당첨 목록 저장 확인 테스트")
    @Test
    void countPrizeHistory() {
        //given
        List<Long> matchWinningNumber = new ArrayList<>();
        List<Long> matchBonusNumber = new ArrayList<>();

        //when
        matchWinningNumber.add(5L);
        matchBonusNumber.add(1L);
        List<String> prizeHistory = Prize.countPrizeHistory(matchWinningNumber, matchBonusNumber);

        //then
        assertThat(prizeHistory.get(0)).isEqualTo("SECOND");
    }
}