package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class BonusNumberInputViewTest {
    private static MockedStatic<Console> console;
    private BonusNumberInputView bonusNumberInputView = new BonusNumberInputView();

    @BeforeAll
    public static void beforeClass() {
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void afterAll() {
        console.close();
    }

    @Test
    void 보너스숫자_입력_올바른_입력() {
        when(Console.readLine()).thenReturn("3");

        int bonusNumber = bonusNumberInputView.getInput();

        assertEquals(3, bonusNumber);
    }
}