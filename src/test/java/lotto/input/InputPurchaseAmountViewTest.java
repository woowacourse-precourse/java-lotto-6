package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.view.InputBonusNumberView;
import lotto.view.InputPurchaseAmountView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputPurchaseAmountViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("구입금액 입력 시 빈 값이 들어오면 에러")
    @Test
    void checkEmpty() {
        String input = "\0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputPurchaseAmountView::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액 입력 시 로또 금액으로 나누어떨어지지 않으면 에러")
    @Test
    void checkDivide() {
        String input = "5001";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputPurchaseAmountView::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액 입력 시 숫자가 아니면 에러")
    @Test
    void checkNumber() {
        String input = "test";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputPurchaseAmountView::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액 입력 성공")
    @Test
    void checkSuccess() {
        String input = "1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = InputBonusNumberView.inputBonusNumber();

        assertThat(result).isEqualTo(1000);
    }

}
