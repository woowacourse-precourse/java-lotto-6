package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerParsingTest {

    @DisplayName("숫자 파싱해보기")
    @Test
    void parseLong_정상적인경우() {
        String input = "2000";

        long parsed = Long.parseLong(input);

        assertThat(parsed).isEqualTo(2000);
    }

    @DisplayName("잘못된 형식 에러확인 파싱해보기")
    @Test
    void parseLong_NumberFormatException_발생() {
        String input = "2000a";

        assertThatThrownBy(() -> Long.parseLong(input))
                .isInstanceOf(NumberFormatException.class);
    }
}
