package lotto.domain;

import static lotto.domain.constant.ErrorMessages.NOT_INTEGER;
import static lotto.domain.constant.ErrorMessages.NOT_UNIQUE;
import static lotto.domain.constant.ErrorMessages.RANGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("provideNumberAndBonusInputs")
    @DisplayName("입력된 당첨 번호와 보너스 번호가 잘못되면 예외가 발생한다.")
    void inputNumbersValidateTest(String inputNumbers, String inputBonus, String result) {
        assertThatThrownBy(() -> new WinningLotto(inputNumbers, inputBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(result);
    }

    private static Stream<Arguments> provideNumberAndBonusInputs() {
        return Stream.of(
                Arguments.of(",2.4,5,-,,", "1", NOT_INTEGER.getMessage()),
                Arguments.of("1,2,3,4,5,6", "-1", RANGE_NUMBER.getMessage()),
                Arguments.of("1,2,3,4,5,6", "!?!", NOT_INTEGER.getMessage()),
                Arguments.of("1,2,3,4,5,6", "46", RANGE_NUMBER.getMessage()),
                Arguments.of("1,2,3,4,5,6", "3", NOT_UNIQUE.getMessage())
        );
    }
}
