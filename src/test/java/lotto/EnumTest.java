package lotto;

import lotto.constant.TestMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumTest {
    @Test
    @DisplayName("Enum 문자열 출력")
    void printEnumTest(){
        String message = TestMessage.MESSAGE.getMessage();
        Assertions.assertThat(message).isEqualTo("TEST 성공");
    }
}
