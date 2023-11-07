package lotto.view;

import lotto.message.ErrorMessage;
import lotto.message.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class OutputViewTest {

    private OutputView output;

    @BeforeEach
    public void setup() {
        output = new OutputView();
    }

    @DisplayName("String.format으로 [ERROR] + message 연결 확인")
    @ParameterizedTest(name = "[ERROR] {0}")
    @EnumSource(value = ErrorMessage.class, names = {"NOT_BLANK", "NOT_MULTIPLE_OF_THOUSAND", "INVALID_SIZE"})
    public void formatErrorMessageTest(Message message) throws Exception {
        String errorFormat = output.ErrorMessageFormat(message.getMessage());
        Assertions.assertThat(errorFormat).isEqualTo("[ERROR] " + message.getMessage());
    }
}