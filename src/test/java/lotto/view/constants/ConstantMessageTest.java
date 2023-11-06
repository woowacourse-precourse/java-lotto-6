package lotto.view.constants;

import static lotto.view.constants.ConstantMessage.RESPONSE_PROFIT_RATE;
import static lotto.view.constants.ConstantMessage.RESPONSE_SECOND;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConstantMessageTest {
    @DisplayName("상수 메시지를 출력한다.")
    @Test
    void printMessage() {
        ConstantMessage.printConstantMessage(RESPONSE_SECOND, 4);
        ConstantMessage.printConstantMessage(RESPONSE_PROFIT_RATE, new BigDecimal("3.15"));
    }
}
