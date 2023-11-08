package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @DisplayName("당첨 결과에 따라 등수를 반환한다.")
    @MethodSource("provideMatchedCount")
    @ParameterizedTest
    void createPrizeByMatchedCount(int matchedCount, boolean matchedBonus, Prize expectedPrize) {
        Prize prize = Prize.valueOf(matchedCount, matchedBonus);
        assertThat(prize).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> provideMatchedCount() {
        return Stream.of(
                Arguments.arguments(0, false, Prize.NOTHING),
                Arguments.arguments(3, false, Prize.FIFTH),
                Arguments.arguments(4, false, Prize.FOURTH),
                Arguments.arguments(5, false, Prize.THIRD),
                Arguments.arguments(5, true, Prize.SECOND),
                Arguments.arguments(6, false, Prize.FIRST)
        );
    }
}
