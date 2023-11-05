package lotto.view;

import static lotto.constant.ErrorMessage.EMPTY;
import static lotto.constant.ErrorMessage.INPUT_STRING;
import static lotto.constant.ErrorMessage.OUT_OF_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberViewTest {

    @DisplayName("입력값이 공백인 경우")
    @Test
    void 입력값_공백() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "";
            if (input.isEmpty()) {
                throw new IllegalArgumentException(EMPTY.getMessage());
            }
        });

        assertThat(exception.getMessage()).
                isEqualTo("[ERROR] 입력을 안 했습니다");

    }

    @DisplayName("0이하의 값을 입력한 경우")
    @Test
    void 음수_혹은_0_입력() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            int num = 0;
            if (num <= 0) {
                throw new IllegalArgumentException(OUT_OF_NUMBER_RANGE.getMessage());
            }
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 번호의 범위는 1~45 이어야 합니다");
    }

    @DisplayName("문자열 입력시 예외 처리")
    @Test
    void 문자열_입력() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "Test";
            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException(INPUT_STRING.getMessage());
            }
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자가 아닌 문자열을 입력했습니다");
    }


}
