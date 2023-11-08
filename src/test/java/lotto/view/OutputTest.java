package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {

    @Test
    @DisplayName("formatter 테스트")
    void printMessageTest() {
        String format = "총 수익률은 %.1f%%입니다.";
        Output.printMessage(format, 62.5);
    }
}