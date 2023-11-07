package lotto.global;

import lotto.global.constant.message.ProfitMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorMessageTest {

    @Test
    void 수익률_메시지가_잘_나오는지_확인() {
        Double profitRate = 100.0;

        String expected = "총 수익률은 100.0%입니다.";

        String result = ProfitMessage.PROFIT_MESSAGE.makeMessage(profitRate);

        assertThat(result)
                .isEqualTo(expected);
    }
}
