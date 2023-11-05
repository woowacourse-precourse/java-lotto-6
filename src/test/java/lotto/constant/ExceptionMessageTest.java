package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionMessageTest {
    @Test
    @DisplayName("Exception 메세지는 [ERROR]로 시작해야 한다.")
    void exceptionMessagePrefix() {
        // given
        ExceptionMessage exceptionMessage = ExceptionMessage.DUPLICATE;

        // when
        String expectExceptionMessagePrefix = "[ERROR]";

        // then
        assertThat(exceptionMessage.toString()).startsWith(expectExceptionMessagePrefix);
    }
}
