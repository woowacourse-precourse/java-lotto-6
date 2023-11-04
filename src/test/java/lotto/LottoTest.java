package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideUniqueNumbers() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(Set.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(Set.of(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(Set.of(1, 2, 7, 8, 9, 10), 2)
        );
    }

    @DisplayName("당첨 번호와 발급받은 번호의 일치하는 개수를 반환합니다.")
    @ParameterizedTest
    @MethodSource("provideUniqueNumbers")
    void testCountCorrectLottoNumber(Set<Integer> prizeNumbers, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int result = lotto.countCorrectLottoNumber(prizeNumbers);

        assertEquals(result, expected);
    }
}