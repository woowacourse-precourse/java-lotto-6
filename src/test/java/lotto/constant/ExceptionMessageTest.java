package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ExceptionMessageTest {
    @ParameterizedTest
    @DisplayName("Exception 메세지는 [ERROR]로 시작해야 한다.")
    @EnumSource(value = ExceptionMessage.class)
    void exceptionMessagePrefix(ExceptionMessage exceptionMessage) {
        // when
        String expectExceptionMessagePrefix = "[ERROR]";

        // then
        assertThat(exceptionMessage.toString()).startsWith(expectExceptionMessagePrefix);
    }
}
