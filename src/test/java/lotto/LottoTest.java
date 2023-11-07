package lotto;

import java.util.stream.Stream;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Lotto 정상 생성 테스트")
    @MethodSource("provideNumbersForValidLotto")
    void testValidLotto(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideNumbersForValidLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(10, 20, 30, 40, 41, 42))
        );
    }

    @ParameterizedTest
    @DisplayName("로또 부적절한 사이즈 테스트")
    @MethodSource("provideNumbersForInvalidSize")
    void testInvalidSize(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNumbersForInvalidSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @DisplayName("로또 중복 숫자 테스트")
    @MethodSource("provideNumbersForDuplicateNumbers")
    void testDuplicateNumbers(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자는 중복될 수 없습니다.");
    }

    private static Stream<Arguments> provideNumbersForDuplicateNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 2, 3, 4, 5)),
                Arguments.of(List.of(42, 42, 43, 44, 45, 46))
        );
    }
}