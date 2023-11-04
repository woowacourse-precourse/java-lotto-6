package lotto.domain.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

class LottoMachineValidationHandlerTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,100})
    @DisplayName("1장 이상의 로또를 구매하면 예외가 발생하지 않는다.")
    void validationMinGenerateLottoCount(int count) {
        // given // when // then
        LottoMachineValidationHandler.validationMinGenerateLottoCount(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1,-2,-100})
    @DisplayName("0장 이하의 로또를 구매하면 예외가 발생한다.")
    void validationMinGenerateLottoCountException(int count) {
        // given // when // then
        assertThatThrownBy(() -> LottoMachineValidationHandler.validationMinGenerateLottoCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachineValidationHandler.INVALID_LOTTO_GENERATE_COUNT_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호가 모두 숫자이면 예외가 발생하지 않는다.")
    void validationAllNumeric() {
        // given
        List<String> bonusNumbers = List.of("1", "2", "3", "4", "5");
        // when // then
        LottoMachineValidationHandler.validationAllNumeric(bonusNumbers);
    }

    @ParameterizedTest
    @MethodSource("invalidBonusNumbers")
    @DisplayName("당첨 번호가 모두 숫자가 아니면 예외가 발생한다.")
    void validationAllNumericException(List<String> bonusNumbers) {
        // given // when // then
        assertThatThrownBy(() -> LottoMachineValidationHandler.validationAllNumeric(bonusNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachineValidationHandler.INVALID_LOTTO_WINNING_NUMBER);
    }

    private static Stream<List<String>> invalidBonusNumbers() {
        return Stream.of(
                List.of("1", "a", "30", "42", "5"),
                List.of("1", ".", "30", "42", "5"),
                List.of("1", "칠", "30", "42", "5"),
                List.of("1", " ", "30", "42", "5")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "10", "100"})
    @DisplayName("보너스 번호가 숫자이면 예외가 발생하지 않는다.")
    void validationNumeric(String bonusNumber) {
        // given // when // then
        LottoMachineValidationHandler.validationNumeric(bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"칠", "a", ".", " "})
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void validationNumericException(String bonusNumber) {
        // given // when // then
        assertThatThrownBy(() -> LottoMachineValidationHandler.validationNumeric(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachineValidationHandler.INVALID_LOTTO_BONUS_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 20, 30, 40, 45})
    @DisplayName("보너스 번호가 1~45 사이의 숫자이면 예외가 발생하지 않는다.")
    void validationNumbersRange(Integer bonusNumber) {
        // given // when // then
        LottoMachineValidationHandler.validationNumbersRange(bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    void validationNumericException(Integer bonusNumber) {
        // given // when // then
        assertThatThrownBy(() -> LottoMachineValidationHandler.validationNumbersRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachineValidationHandler.INVALID_LOTTO_BONUS_NUMBER_RANGE);
    }
}