package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class WinningNumbersInputViewTest {
    private static MockedStatic<Console> console;
    private WinningNumbersInputView winningNumbersInputView = new WinningNumbersInputView();

    @BeforeAll
    public static void beforeClass() {
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void afterAll() {
        console.close();
    }

    @Test
    void 당첨숫자_입력_올바른_입력() {
        when(Console.readLine()).thenReturn("1,2,3,4,5,6");

        List<Integer> winningNumbers = winningNumbersInputView.getInput();

        assertEquals(List.of(1,2,3,4,5,6), winningNumbers);
    }
}