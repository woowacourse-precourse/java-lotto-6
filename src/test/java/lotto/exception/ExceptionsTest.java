package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ExceptionsTest {
    @DisplayName("숫자 이외 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123qwe456", "qwe789", "014zxc", "./\\?", "   ", "3.141592"})
    void giveNotNumberInput(String argument) {
        assertThatThrownBy(() -> Exceptions.checkIsNumber(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 값을 입력하면 정상적으로 가동된다.")
    @ParameterizedTest
    @ValueSource(strings = {"12356", "192", "1", "092"})
    void giveNumberInput(String argument) {
        assertThatCode(() -> Exceptions.checkIsNumber(argument))
                .doesNotThrowAnyException();
    }

    @DisplayName("1000단위 절삭되지 않은 숫자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1010, 999, 1001, 1111, 10001, 9800})
    void giveNotThousandUnit(int argument) {
        assertThatThrownBy(() -> Exceptions.checkIsThousandUnit(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자연수가 아닌 숫자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, -9874654})
    void giveNotNationalNumber(int argument) {
        assertThatThrownBy(() -> Exceptions.checkIsNationalNumber(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 범위가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 9999, 3901, 9249, 90844223})
    void giveOverLottoRange(int argument) {
        assertThatThrownBy(() -> Exceptions.checkLottoRange(List.of(argument)));
    }

    @DisplayName("로또 숫자가 중복된 값이면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("listProvider")
    void giveDuplicateLotto(List<Integer> argument) {
        assertThatThrownBy(() -> Exceptions.checkLottoDuplicate(argument));
    }

    static Stream<List<Integer>> listProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 45, 43, 33, 2),
                Arrays.asList(1, 1, 1, 1, 1, 1, 1));
    }
}
