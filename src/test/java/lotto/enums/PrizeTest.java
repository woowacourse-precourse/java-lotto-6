package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {
    private static Stream<Arguments> providePrize() {
        return Stream.of(
                Arguments.of(6, false, Prize.FIRST),
                Arguments.of(5, true, Prize.SECOND),
                Arguments.of(5, false, Prize.THIRD),
                Arguments.of(4, true, Prize.FOURTH),
                Arguments.of(4, false, Prize.FOURTH),
                Arguments.of(3, true, Prize.FIFTH),
                Arguments.of(2, false, Prize.NONE),
                Arguments.of(1, true, Prize.NONE),
                Arguments.of(0, false, Prize.NONE),
                Arguments.of(0, true, Prize.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("providePrize")
    void 로또_번호가_일치한_개수와_보너스에_따라_보상을_반환한다(int matchedCount, boolean matchedBonus, Prize expected) {
        // when
        Prize prize = Prize.valueOf(matchedCount, matchedBonus);

        // then
        assertThat(prize).isEqualTo(expected);
    }
}