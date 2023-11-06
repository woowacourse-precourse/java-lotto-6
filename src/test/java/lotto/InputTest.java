package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("구입 금액 입력시 숫자가 아닌값이 입력되면 예외가 발생한다.")
    @Test
    void askPurchaseAmountByNoneInteger() {
        System.setIn(createUserInput("2000r"));
        assertThatThrownBy(InputView::askPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 숫자가 아닙니다.");
    }

    @DisplayName("당첨 번호 입력시 숫자가 아닌값이 입력되면 예외가 발생한다.")
    @Test
    void askWinningNumbersByNoneInteger() {
        System.setIn(createUserInput("1q,2w,3e,4r,5t,6y"));
        assertThatThrownBy(InputView::askWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 숫자가 아닙니다.");
    }

    @DisplayName("당첨 번호 입력시 숫자가 아닌값이 입력되면 예외가 발생한다.")
    @Test
    void askBonusNumberByNoneInteger() {
        System.setIn(createUserInput("1q"));
        assertThatThrownBy(InputView::askBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 숫자가 아닙니다.");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

