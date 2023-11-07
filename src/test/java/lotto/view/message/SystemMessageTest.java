package lotto.view.message;

import static lotto.view.message.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SystemMessageTest {
    @Test
    void 메세지_얻기() {
        assertThat(INPUT_PURCHASE_AMOUNT.getMessage()).isEqualTo("구입금액을 입력해 주세요.");
    }
}