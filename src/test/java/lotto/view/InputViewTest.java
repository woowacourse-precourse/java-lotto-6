package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("budget 입력시 문자열 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1", " ", "df", "+-","0"})
    void inputBudgetTest(String budget) {
        System.setIn(input(budget));

        assertThatThrownBy(InputView::inputBudget)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Winning Number 입력시 문자열 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,7",
            ",,,,, ",
            "df,2,34,7,8,",
            "+-"})
    void inputWinningNumberTest(String winningNumber) {
        System.setIn(input(winningNumber));

        assertThatThrownBy(InputView::inputWinningNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus Number 입력시 문자열 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1", " ", "df", "+-","0"})
    void inputBonusNumberTest(String bonusNumber) {
        System.setIn(input(bonusNumber));

        assertThatThrownBy(InputView::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    InputStream input(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
