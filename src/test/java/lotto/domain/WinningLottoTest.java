package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("grade 메소드 테스트")
    class Grade {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 정답_로또로_다른_로또를_채점하면_같은값_개수를_반환하는지_테스트(Lotto source, Lotto target, int expected) {


            WinningLotto winningLotto = new WinningLotto(source);

            assertThat(winningLotto.grade(target)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                    Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), 3),
                    Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), 0)
            );
        }
    }
}