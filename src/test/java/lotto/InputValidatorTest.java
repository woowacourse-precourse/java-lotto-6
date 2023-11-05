는package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.InputValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @Test
    @BeforeAll
    void init() {
        InputValidator validator = new InputValidator();
    }
    @ParameterizedTest
    @DisplayName("입력이 빈 값이면 예외가 발생한다")
    @ValueSource(strings = {""," "})
    void createInputIsNull(String input) {
        assertThatThrownBy(() -> validator.validateBlankInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 빈 값을 입력할 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("입력이 정수가 아니면 예외가 발생한다")
    @ValueSource(strings = {"234","abc"})
    void createInputIsNull(String input) {
        assertThatThrownBy(() -> validator.validateBlankInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 정수가 아닌 다른 문자는 입력할 수 없습니다");
    }

    @Test
    @DisplayName("금액 입력이 1000이상 100,000이하의 정수가 아니면 예외가 발생한다")
    void createCostInputOutOfSize() {
        assertThatThrownBy(() -> validator.validateCostOutofSize("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구매 금액은 1000원 이상 100,000원 이하로만 가능합니다");

    }

    @Test
    @DisplayName("입력된 금액이 1000원 단위가 아니면 예외가 발생한다")
    void createCostInputNotInUnit() {
        assertThatThrownBy(() -> validator.validateCostNotInUnit(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구매 금액은 1000원 단위로만 가능합니다");
    }
}
