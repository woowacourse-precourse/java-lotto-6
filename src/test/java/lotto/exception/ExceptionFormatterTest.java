package lotto.exception;

import lotto.message.ErrorMessage;
import lotto.message.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class ExceptionFormatterTest {

    @DisplayName("String.format으로 [ERROR] + message 연결 확인")
    @ParameterizedTest(name = "[ERROR] {0}")
    @EnumSource(value = ErrorMessage.class, names = {"NOT_BLANK"})
    public void formatErrorMessageTest(Message message) throws Exception {
        String errorFormat = ExceptionFormatter.formatErrorMessage(message.getMessage());
        Assertions.assertThat(errorFormat).isEqualTo("[ERROR] " + message.getMessage());
    }

//    @DisplayName("@EnumSource를 이용해 IllegalExceptionHandler() 테스트 ")
//    @ParameterizedTest(name = "[ERROR] {0}")
//    @EnumSource(value = ErrorMessage.class, names = {"NOT_BLANK"})
//    public void IllegalExceptionHandlerTest(Message message) throws Exception {
//        String errorFormat = ExceptionFormatter.IllegalExceptionHandler(message);
//        Assertions.assertThat(errorFormat).isEqualTo("[ERROR] " + message.getMessage());
//    }

}