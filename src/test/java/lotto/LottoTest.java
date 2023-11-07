package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.AssertionsForClassTypes;
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

    static Stream<Arguments> provideInvalidNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(-32, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 999))
        );
    }

    @DisplayName("랜덤으로 발급된 로또번호가 규정범위를 벗어난 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void createLottoNumberThrowExceptionWhenNumbersAreOutOfRange(List<Integer> numbers) {

        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1 ~ 45 사이로 발급되어야 합니다.");
    }

    static Stream<Arguments> provideUniqueNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(List.of(1, 2, 7, 8, 9, 10), 2)
        );
    }

    @DisplayName("당첨 번호와 발급받은 번호의 일치하는 개수를 반환합니다.")
    @ParameterizedTest
    @MethodSource("provideUniqueNumbers")
    void testCountCorrectLottoNumber(List<Integer> prizeNumbers, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int result = lotto.countCorrectLottoNumber(prizeNumbers);

        assertEquals(result, expected);
    }

    @DisplayName("숫자를 오름차순으로 정렬합니다.")
    @Test
    void createUnsortingNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));

        String expected = List.of(1, 2, 3, 4, 5, 6).toString();
        String result = lotto.toString();

        assertEquals(expected, result);
    }


}