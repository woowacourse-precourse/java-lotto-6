package lotto;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class LottoControllerTest {
        @DisplayName("구입 금액이 숫자가 아닌경우")
        @Test
        void inputPriceIsNotNumber() {
                assertThatThrownBy(() -> new LottoController("a"))
                        .isInstanceOf(IllegalArgumentException.class);
        }
}
