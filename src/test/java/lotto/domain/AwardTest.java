package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AwardTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("getReward 메소드 테스트")
    class GetReward {
        @ParameterizedTest(name = "입력값이 {0}인 경우")
        @MethodSource("awardCheckProvider")
        void 상금_반환_테스트(Award target, int expected) {
            assertThat(target.getReward()).isEqualTo(expected);
        }

        private Stream<Arguments> awardCheckProvider() {
            return Stream.of(
                    Arguments.of(Award.ONE, 0),
                    Arguments.of(Award.TWO, 0),
                    Arguments.of(Award.THREE, 5_000),
                    Arguments.of(Award.FOUR, 50_000),
                    Arguments.of(Award.FIVE, 1_500_000),
                    Arguments.of(Award.FIVE_BONUS, 30_000_000),
                    Arguments.of(Award.SIX, 2_000_000_000)
            );
        }
    }
}
