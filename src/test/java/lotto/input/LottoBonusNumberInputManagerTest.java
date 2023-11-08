package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBonusNumberInputManagerTest {

    @DisplayName("로또 보너스 번호 크기 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "9999999999999"})
    void bonusSizeException(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberInputManager.fromString(input, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WRONG_BONUS_NUMBER_SIZE);
    }

    @DisplayName("로또 보너스 번호 중복 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void bonusDuplicateException(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberInputManager.fromString(input, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_BONUS_NUMBER);
    }

    @DisplayName("정상 동적 테스트")
    @ParameterizedTest
    @MethodSource("okParameter")
    void ok(String input, int expected, List<Integer> lottoNumbers) {
        int bonusNumber = LottoBonusNumberInputManager.fromString(input, lottoNumbers);
        assertThat(bonusNumber)
                .isEqualTo(expected);
    }

    static Stream<Arguments> okParameter() {
        return IntStream.range(7, 46)
                .boxed()
                .map(integer -> Arguments.of(String.valueOf(integer), integer, List.of(1, 2, 3, 4, 5, 6)));
    }
}