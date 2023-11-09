package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class RankTest {

    static Stream<Arguments> getterParameter() {
        return Stream.of(
                Arguments.of("3개 일치, 5,000원", Rank.CORRECT_THREE, 3, 5000L),
                Arguments.of("4개 일치 50,000원", Rank.CORRECT_FOUR, 4, 50000L),
                Arguments.of("5개 일치 1,500,000원", Rank.CORRECT_FIVE, 5, 1500000L),
                Arguments.of("5개 일치 + 보너스 일치, 30,000,000원", Rank.CORRECT_FIVE_BONUS, 5, 30000000L),
                Arguments.of("6개 일치, 2,000,000,000원", Rank.CORRECT_SIX, 6, 2000000000L)
        );
    }

    static Stream<Arguments> ofParameter() {
        return Stream.of(
                Arguments.of("3개 일치", 3, false, Rank.CORRECT_THREE),
                Arguments.of("4개 일치", 4, false, Rank.CORRECT_FOUR),
                Arguments.of("4개 일치 + 보너스 일치", 4, true, Rank.CORRECT_FOUR),
                Arguments.of("5개 일치", 5, false, Rank.CORRECT_FIVE),
                Arguments.of("5개 일치 + 보너스 일치", 5, true, Rank.CORRECT_FIVE_BONUS),
                Arguments.of("6개 일치", 6, false, Rank.CORRECT_SIX)
        );
    }

    @DisplayName("로또 등수에 따른 당첨 숫자 개수, 금액을 반환한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("getterParameter")
    void getCorrectCount(String testName, Rank rank, int correctCount, Long winningAmount) {
        assertThat(rank.getCorrectCount()).isEqualTo(correctCount);
        assertThat(rank.getWinningAmount()).isEqualTo(winningAmount);
    }

    @DisplayName("당첨 숫자 개수와 보너스 번호를 기반으로 등수 객체를 반환한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("ofParameter")
    void of(String testName, int correctCount, boolean checkBonus, Rank rank) {
        assertThat(Rank.of(correctCount,checkBonus)).isEqualTo(rank);
    }
}