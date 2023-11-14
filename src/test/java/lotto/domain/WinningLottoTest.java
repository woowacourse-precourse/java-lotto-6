package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("WinningLotto와 Lotto를 비교하는 테스트")
    class ComparingTest {

        @ParameterizedTest
        @MethodSource("parameterProvider")
        void compareLottoTest(List<Integer> winningLottoNumbers, int bonusNumber, List<Integer> lottoNumbers, int matchCount) {
            Lotto lotto = new Lotto(lottoNumbers);
            WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
            assertThat(winningLotto.compareLotto(lotto)).isEqualTo(matchCount);
            assertThat(winningLotto.compareBonusNumber(lotto)).isTrue();
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 11, List.of(1, 3, 5, 7, 9, 11), 3),
                    Arguments.of(List.of(13, 15, 17, 19, 21, 22), 23, List.of(23, 25, 27, 29, 31, 32), 0),
                    Arguments.of(List.of(33, 35, 37, 39, 41, 43), 45, List.of(33, 35, 39, 41, 43, 45), 5)
            );
        }
    }
}