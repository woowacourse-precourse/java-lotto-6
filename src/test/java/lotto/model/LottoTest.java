package lotto.model;

import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @Test
    void 당첨_번호와_비교해_같은_숫자들의_개수를_반환한다() {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final int matchCount = lotto.getMatchCount(targetLotto);

        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("generateOutOfSize")
    void createLottoOutOfSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1에서 45 사이에서 벗어난 수가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateOutOfRange")
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> generateOutOfSize() {
        return Stream.of(
            List.of(1, 2, 3, 4, 5),
            List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    private static Stream<List<Integer>> generateOutOfRange() {
        return Stream.of(
            List.of(1, 2, 3, 4, 5, MIN_RANDOM_NUMBER - 1),
            List.of(1, 2, 3, 4, 5, MAX_RANDOM_NUMBER + 1)
        );
    }

}