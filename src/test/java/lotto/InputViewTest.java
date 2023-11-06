package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import lotto.view.InputValidator;

public class InputViewTest {
    private static final String NULL_VALUE = null;
    private static final String EMPTY_VALUE = "";
    private static final String SPACE_VALUE = " ";

    @Test
    @DisplayName("플레이어가 null 값을 입력한 경우 예외를 던진다.")
    void nullValueTest() {
        assertThatThrownBy(() -> InputValidator.validateInput(NULL_VALUE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 비어있는 값을 입력한 경우 예외를 던진다.")
    void emptyValueTest() {
        assertThatThrownBy(() -> InputValidator.validateInput(EMPTY_VALUE))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateInput(SPACE_VALUE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}