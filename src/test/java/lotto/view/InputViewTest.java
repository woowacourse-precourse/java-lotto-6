package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @DisplayName("숫자가 아닌 입력값, 1000 단위가 아닌 수, 100,000을 초과하는 수, 1000미만의 수 입력시 예외 발생")
    @ValueSource(strings = {"$d", "900", "0", "1000000"})
    void askPurchaseAmountTest(String input) {
        systemIn(input);
        assertThatThrownBy(InputView::askPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}