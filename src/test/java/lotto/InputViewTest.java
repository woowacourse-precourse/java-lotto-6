package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    @AfterEach
    void teardown() {
        Mockito.framework().clearInlineMocks();
    }

    @Test
    void 구입금액_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "5000";
        mockConsoleReadLine(input);

        // Act
        int purchase = inputView.getPurchase();

        // Assert
        assertEquals(5000, purchase);
    }

    @Test
    void 당첨번호_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "1 2 3 4 5 6";
        mockConsoleReadLine(input);

        // Act
        var winNumbers = inputView.getWinNumbers();

        // Assert
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winNumbers);
    }

    @Test
    void 보너스번호_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "7";
        mockConsoleReadLine(input);

        // Act
        int bonusNumber = inputView.getBounsNumbers();

        // Assert
        assertEquals(7, bonusNumber);
    }

    private void mockConsoleReadLine(String input) {
        Mockito.mockStatic(Console.class);
        Mockito.when(Console.readLine()).thenReturn(input);
    }
}
