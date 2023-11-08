package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @DisplayName("수가 아닌 문자열이 들어갔을 때, 예외 발생")
    @Test
    void validateOrderTest_noneDigit() {
        assertThatThrownBy(() -> InputValidator.validateOrderPrice("8000k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나뉘어질 수 없는 수, 예외 발생")
    @Test
    void validateOrderTest_cantDivide1000() {
        assertThatThrownBy(() -> InputValidator.validateOrderPrice("8700"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개가 아닌 수가 입력됨, 예외 발생")
    @Test
    void validateLottoNumbersTest_notSixNumber() {
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 범위가 아닌 수가 입력됨, 예외 발생")
    @Test
    void validateLottoNumbersTest_outOfNumberRange() {
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1,2,0,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("21,32,63,44,55,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 수가 입력됨, 예외 발생")
    @Test
    void validateLottoNumbersTest_duplicatedNumber() {
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1,1,2,2,3,3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("1,2,3,4,5,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수가 아닌 수가 입력됨, 예외 발생")
    @Test
    void validateBonusNumberTest_notNumber() {
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("7,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("k"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 범위가 아닌 수가 입력됨, 예외 발생")
    @Test
    void validateBonusNumberTest_outOfNumberRange() {
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("46"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}