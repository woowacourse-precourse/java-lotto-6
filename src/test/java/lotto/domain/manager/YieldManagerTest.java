package lotto.domain.manager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.ResultLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class YieldManagerTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("makeYield 메소드 테스트")
    class MakeYield {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 상_리스트에_따라_상금을_잘_반환하는지_테스트(List<ResultLotto> result, float expected) {
            assertThat(YieldManager.makeYield(result)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            // 2000원에 -> 6000만원 3000000% (30000배)
            // 4000원에 -> 20000원 500% (5배)
            // 8000원에 -> 5000원 62.5% (0.65배)
            return Stream.of(
                    Arguments.of(List.of(ResultLotto.FIVE_BONUS, ResultLotto.FIVE_BONUS), 30_000_00f),
                    Arguments.of(List.of(ResultLotto.THREE, ResultLotto.THREE, ResultLotto.THREE, ResultLotto.THREE),
                            500.0f),
                    Arguments.of(List.of(ResultLotto.ZERO, ResultLotto.ZERO, ResultLotto.ZERO, ResultLotto.ZERO,
                            ResultLotto.ZERO, ResultLotto.ZERO, ResultLotto.ZERO, ResultLotto.THREE), 62.5f)
            );
        }
    }

}