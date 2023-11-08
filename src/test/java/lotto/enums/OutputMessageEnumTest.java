package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputMessageEnumTest {

    @DisplayName("OUTPUT_RESULT_END_MESSAGE 출력 테스트")
    @Test
    void print_OUTPUT_RESULT_END_MESSAGE() {
        String message = OutputMessageEnum.OUTPUT_RESULT_END_MESSAGE.getMessage(14.234);
        String result = "총 수익률은 14.2%입니다.";
        assertThat(message).isEqualTo(result);
    }
    
}