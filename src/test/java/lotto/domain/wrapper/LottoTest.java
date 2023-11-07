package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.handler.ErrorHandler.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    private static Stream<Arguments> generateBasicLotto() {
        return Stream.of(
                Arguments.of(Lotto.create(List.of(1, 20, 10, 45, 40, 30)), List.of(1, 10, 20, 30, 40, 45)),
                Arguments.of(Lotto.create(List.of(1, 3, 6, 5, 11, 10)), List.of(1, 3, 5, 6, 10, 11))
        );
    }

    @DisplayName("로또 번호에 숫자로 변환될 수 없는 타입이 들어가면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,육", "1,2,3,4,5,^", "1,2,3,4,5, ", "1,2,3,4,5,@"})
    void createLottoByInconvertibleType(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCONVERTIBLE_TYPE.getException().getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개 보다 적거나 많다면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9", "1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3"})
    void createLottoByInvalidSize(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_SIZE.getException().getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,5,5,5", "1,2,3,3,3,3"})
    void createLottoByDuplicatedNumber(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER.getException().getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45 사이의 범위가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,56", "-1,2,3,4,5,6", "0,2,3,4,5,6"})
    void createLottoByInvalidRange(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getException().getMessage());
    }

    @DisplayName("로또 번호가 오름차순으로 정상적으로 반환된다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @MethodSource("generateBasicLotto")
    void createLotto(Lotto lotto, List<Integer> expected) {
        assertThat(lotto.sortLottoNumbers()).isEqualTo(expected);
    }
}