package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    void 로또_구매_금액() {
        // given

        // when
        String inputMoney = outputView.inputMoney();

        // then
        Assertions.assertThat("구매금액을 입력해주세요.").isEqualTo(inputMoney);
    }
}
