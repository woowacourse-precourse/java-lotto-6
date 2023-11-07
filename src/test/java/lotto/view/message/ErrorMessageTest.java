package lotto.view.message;

import static lotto.view.message.ErrorMessage.EMPTY_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ErrorMessageTest {
    @Test
    void ERROR_포함_확인() {
        assertThat(EMPTY_INPUT.getErrorMessage()).contains("[ERROR]");
    }

    @Test
    void 에러_메세지_얻기() {
        assertThat(EMPTY_INPUT.getErrorMessage()).isEqualTo("[ERROR] 빈 입력입니다.");
    }
}