package lotto.constant;

import static lotto.constant.ErrorMessage.INPUT_NOT_DIGIT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {

    @DisplayName("에러 메세지를 문자열로 변환하면 앞에 [ERROR]가 붙는다.")
    @Test
    void toStringTest() {
        // when
        String result = INPUT_NOT_DIGIT.toString();

        // then
        assertThat(result).contains("[ERROR]");
    }
}
