package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class PurchaseAmountInputViewTest {

    private static MockedStatic<Console> console;
    private PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();

    @BeforeAll
    public static void beforeClass() {
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void afterAll() {
        console.close();
    }

    @Test
    void 구입금액_입력_올바른_입력() {
        when(Console.readLine()).thenReturn("5000");

        int purchaseAmount = purchaseAmountInputView.getInput();

        assertEquals(5000, purchaseAmount);
    }
}