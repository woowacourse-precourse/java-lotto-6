package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("입력값에 중복값이 있으면 예외가 발생한다.")
    @Test
    void checkDuplicated() {
        String[] selectedNumbers = {"1", "1", "2", "3", "4", "5"};
        assertThatThrownBy(() -> inputValidator.checkDuplicated(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요.");
    }

    @DisplayName("6개 이상의 숫자를 입력하면 예외가 발생한다.")
    @Test
    void checkNumbersLength() {
        String[] selectedNumbers = {"5", "6", "7", "8", "2", "17", "43", "24", "35"};
        assertThatThrownBy(() -> inputValidator.checkNumbersLength(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자를 입력해주세요.");
    }

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void isNumber() {
        String[] selectedNumbers = {"8", "@", "17", "43", "24", "35"};
        assertThatThrownBy(() -> inputValidator.isNumber(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
    }

    @DisplayName("6개 번호 입력값의 범위가 (1~45)가 아니면 예외가 발생한다.")
    @Test
    void checkNumberRange() {
        List<Integer> numbers = Arrays.asList(3, 5, 45, 0, 23, 30);
        assertThatThrownBy(() -> inputValidator.checkNumbersRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 사이의 값을 선택하세요.");

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 52, 77, 100, 2345})
    void checkLottoNumberRange(int num) {
        assertThatThrownBy(() -> inputValidator.checkLottoNumberRange(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 사이의 값을 선택하세요.");
    }

    @DisplayName("보너스 1개, 숫자 이외의 값이 입력될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ㄱ", "o", "@", "!"})
    void checkIsBonusNumber(String inputValue) {
        assertThatThrownBy(() -> inputValidator.checkIsBonusNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
    }

    @DisplayName("번호 입력 구분자가 쉼표(,)가 아닐 경우 예외가 발생한다.")
    @Test
    void ensureCommaDelimiter() {
        assertThatThrownBy(() -> inputValidator.ensureCommaDelimiter("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}