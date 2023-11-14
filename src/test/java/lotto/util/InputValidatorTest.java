package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("구입 금액 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-1000.1", "1000.1", "0", "1200", "한글", "english", "!", " "})
    void validatePurchaseAmountTest(String playerInput) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(playerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 테스트")
    @ParameterizedTest
    @MethodSource("makeInvalidWinningNumbersSource")
    void validateWinningNumbersTest(String playerInput) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(playerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<String> makeInvalidWinningNumbersSource() {
        return Stream.of(
                "1,2,3,4,5,-1",
                "한글,1,2,3,4,5,",
                "english,1,2,3,4,5",
                "1.1,1,2,3,4,5",
                "0,1,2,3,4,5",
                "1,2,3,4,5",
                "!,@,#,$,%,^"
        );
    }

    @DisplayName("보너스 번호 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1.1", "-1.1", "!", "@", "한글", "english", " "})
    void validateBonusNumberTest(String playerInput){
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(playerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}