package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("getInvalidSizeLottoNumbers")
    void createNotLottoBySize(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않는 숫자 6개여야 합니다.");
    }

    private static Stream<Arguments> getInvalidSizeLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않는 숫자 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 1부터 45사이에 숫자가 아닌 경우 예외가 발생하다")
    @ParameterizedTest
    @MethodSource("getInvalidRangeLottoNumber")
    void createLottoByRangeNumber(List<Integer> invalidRangeNumbers) {
        assertThatThrownBy(() -> new Lotto(invalidRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> getInvalidRangeLottoNumber() {
        return Stream.of(
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(-1, 2, 3, 4, 5, 6))
        );
    }
}