package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.InputParser;
import lotto.utils.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("구입 금액에 숫자가 아닌 값 포함되어 있으면 예외가 발생한다.")
    @Test
    void invalidInputWithNonNumericPurchaseAmount() {
        String input = "2000won";
        assertThatThrownBy(() -> inputValidator.validateNonNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
    }

    @DisplayName("구입 금액이 1000원으로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void invalidPurchaseAmountNotDivisible() {
        String input = "3500";
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 단위로 입력해주세요.");
    }

    @DisplayName("로또 번호에 숫자가 아닌 값 포함되어 있으면 예외가 발생한다.")
    @Test
    void invalidInputNonNumeric() {
        InputParser inputParser = new InputParser();
        String input = "1, 2, Three, 4, 5, 6";
        assertThatThrownBy(() -> inputParser.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
    }

    @DisplayName("로또 번호에 1~45 범위를 벗어나는 값이 있으면 예외가 발생한다.")
    @Test
    void invalidInputNumberRange() {
        List<Integer> input = List.of(1, 2, 46, 4, 5, 9);
        assertThatThrownBy(() -> inputValidator.validateNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자는 1에서 45 사이어야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void invalidInputDuplicateNumbers() {
        List<Integer> input = List.of(18, 21, 28, 30, 30, 45);
        assertThatThrownBy(() -> inputValidator.validateDuplicateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.");
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void invalidInputNumbersByOverSize() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> inputValidator.validateWinningNumbersCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호의 개수를 만족시키지 못합니다.");
    }

    @DisplayName("로또 번호의 개수가 6개가 안될 경우 예외가 발생한다.")
    @Test
    void invalidInputNumbersByUnderSize() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> inputValidator.validateWinningNumbersCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호의 개수를 만족시키지 못합니다.");
    }

}
