package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[Test - InputValidator]")
public class InputValidatorTest {
    @Test
    @DisplayName("빈 값에 대한 validation 테스트")
    void validateInputIsEmptyTest() {
        // Given
        String input = "";

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateInputIsEmpty(input))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("값이 숫자가 아닌 것 대한 validation 테스트")
    void validateInputIsNumberTest() {
        // Given
        String input = "r";

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateInputIsNumber(input))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호 범위에 대한 validation 테스트")
    void validateLottoNumberIsNotRightRangeTest() {
        // Given
        String input = "47";

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateLottoNumberIsNotInRightRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호 개수에 대한 validation 테스트")
    void validateAmountOfWinningLottoNumberTest() {
        // Given
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6,7);

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateAmountOfWinningLottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호 개수에 대한 validation 테스트")
    void validateDuplicatedWinningLottoNumberTest() {
        // Given
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,5);

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateDuplicatedWinningLottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호 중복에 대한 validation 테스트")
    void validateIsWinningLottoNumberContainsTest() {
        // Given
        List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        String bonusNumber = "3";

        // When & Then
        assertThatThrownBy(() -> InputValidator.validateIsWinningLottoNumberContains(bonusNumber, winningLotto))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }
}
