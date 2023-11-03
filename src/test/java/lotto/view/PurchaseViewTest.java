package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static lotto.constant.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseViewTest {


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

    @DisplayName("공백 입력시 예외 처리")
    @Test
    void 공백_입력() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "";
            if (input.isEmpty()) {
                throw new IllegalArgumentException(EMPTY.getMessage());
            }
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 입력을 안 했습니다");
    }

    @DisplayName("중간에 ',' 가 들어갈 경우")
    @Test
    void 콤마가_들어간_경우() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "14,000";
            if (input.contains(",")) {
                throw new IllegalArgumentException(NOT_CONTAIN_COMMA.getMessage());
            }
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] ',' 을 빼고 숫자만 입력해주세요");
    }

    @DisplayName("1000으로 나누어지지 않는 경우")
    @Test
    void 나머지_존재() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            int num = 1400;
            if (num % 1000 != 0) {
                throw new IllegalArgumentException(NOT_DIVIDE.getMessage());
            }
        });

        assertThat(exception.getMessage()).isEqualTo(("[ERROR] 구입금액은 1000원 단위어야 합니다"));
    }

    @DisplayName("0이하의 값을 입력한 경우")
    @Test
    void 음수_혹은_0_입력() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            int num = 0;
            if (num <= 0) {
                throw new IllegalArgumentException(STRANGE_INTEGER.getMessage());
            }
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 구입금액은 0원 보다 커야합니다");
    }


}

