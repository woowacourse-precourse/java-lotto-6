package lotto.view.constants;

import static lotto.view.constants.ConstantMessage.RESPONSE_FIRST;
import static lotto.view.constants.ConstantMessage.RESPONSE_PROFIT_RATE;
import static lotto.view.constants.ConstantMessage.RESPONSE_SECOND;
import static lotto.view.constants.ConstantMessage.RESPONSE_THIRD;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConstantMessageTest {
    @DisplayName("상수 메시지를 출력한다.")
    @Test
    void printMessage() {
        ConstantMessage.printNotice(RESPONSE_THIRD, 4);
        ConstantMessage.printNotice(RESPONSE_SECOND, 4);
        ConstantMessage.printNotice(RESPONSE_FIRST, 4);
        ConstantMessage.printNotice(RESPONSE_PROFIT_RATE, new BigDecimal("3.15"));
    }
}
