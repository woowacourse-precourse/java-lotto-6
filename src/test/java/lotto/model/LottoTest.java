package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                // 로또번호, 예외
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7), IllegalArgumentException.class),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5), IllegalArgumentException.class),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46), IllegalArgumentException.class),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), IllegalArgumentException.class));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("로또 번호 유효성 테스트")
    void lottovalidateTest(List<Integer> lotto, Class<Exception> expected) {
        assertThatThrownBy(() -> Lotto.from(lotto)).isInstanceOf(expected);
    }

    @Test
    @DisplayName("로또에 숫자가 들어가 있으면 true를 반환")
    void containLottoByNumber() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        // when
        boolean hasNumber = lotto.hasNumber(3);
        // then
        Assertions.assertThat(hasNumber).isTrue();
    }

    @Test
    @DisplayName("로또에 숫자가 없으면 false를 반환")
    void notContainLottoByNumber() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        // when
        boolean hasNumber = lotto.hasNumber(7);
        // then
        Assertions.assertThat(hasNumber).isFalse();
    }

    @Test
    @DisplayName("같은 숫자가 4개 일시 4를 반환해야한다.")
    void sameNumberCounterTest() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.of(Lotto.from(List.of(1, 2, 3, 4, 10, 20)), 40);
        // when
        int count = lotto.sameNumberCounter(winningNumbers);
        // then
        Assertions.assertThat(count).isEqualTo(4);

    }
}