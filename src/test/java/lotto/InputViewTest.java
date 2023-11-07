package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidSizeException;
import lotto.exception.NonNumericAmountException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("사용자가 구입 금액을 1000원 단위로 입력하지 않으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"5500", "3700", "1300"})
    void inputWrongMoney(String input) {
        System.setIn(createUserInput(input));

        InputView inputView = new InputView(new ConsoleReceiver());
        int money = inputView.getMoney();
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(InvalidPurchaseAmountException.class);
    }

    @DisplayName("사용자가 구입 금액을 숫자가 아닌 다른 값으로 입력하면 예외 발생")
    @Test
    void inputInvalidMoney() {
        System.setIn(createUserInput("hello pobi"));
        InputView inputView = new InputView(new ConsoleReceiver());
        assertThatThrownBy(inputView::getMoney)
                .isInstanceOf(NonNumericAmountException.class);
    }

    @DisplayName("당첨 번호 숫자를 6개 입력하지 않으면 예외 발생")
    @Test
    void inputInvalidSize() {
        System.setIn(createUserInput("1,2,3,4,5"));
        InputView inputView = new InputView(new ConsoleReceiver());
        assertThatThrownBy(inputView::getWinningNumbers)
                .isInstanceOf(InvalidSizeException.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

