package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("맞춘 로또 번호의 숫자와 보너스 매치 여부로 상금을 반환한다.")
    @ParameterizedTest
    @MethodSource("getLottoPrizeSource")
    void ofFirst(int matchCount, boolean isBonusIncluded, LottoPrize expected) {
        LottoPrize prize = LottoPrize.of(matchCount, isBonusIncluded);

        assertThat(prize).isEqualTo(expected);
    }

    private static Stream<Arguments> getLottoPrizeSource() {
        return Stream.of(
                Arguments.of(2, false, LottoPrize.LOSE),
                Arguments.of(6, false, LottoPrize.FIRST),
                Arguments.of(5, true, LottoPrize.SECOND),
                Arguments.of(5, false, LottoPrize.THIRD),
                Arguments.of(4, false, LottoPrize.FOURTH),
                Arguments.of(3, false, LottoPrize.FIFTH)
        );
    }
}
