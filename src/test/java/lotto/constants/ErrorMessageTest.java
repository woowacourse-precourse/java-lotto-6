package lotto.constants;

import lotto.constants.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("에러 메시지 상수에 대해")
class ErrorMessageTest {

    static Stream<ErrorMessage> errorMessageSources() {
        return Stream.of(ErrorMessage.values());
    }

    @ParameterizedTest
    @MethodSource("errorMessageSources")
    @DisplayName("[ERROR] 표시가 들어가 있게 메시지를 출력한다.")
    void When_LoopErrorMessageValues_Then_ContainsErrorText(ErrorMessage errorMessage) {
        assertThat(errorMessage.getMessage()).contains("[ERROR] ");
    }
}
