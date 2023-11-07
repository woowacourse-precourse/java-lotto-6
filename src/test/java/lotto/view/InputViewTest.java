package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.exception.LottoValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputStream originalIn = System.in;

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @BeforeEach
    public void setUp() {
        System.setIn(originalIn);
    }

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(originalIn);
        Console.close();
    }

    @Test
    @DisplayName("유효한 구매 금액 입력 시 해당 금액 반환")
    void testInputPurchaseAmountWithValidInput() {
        provideInput("3000\n");
        assertEquals(3000, InputView.inputPurchaseAmount());
    }

    @Test
    @DisplayName("유효하지 않은 구매 금액 입력 시 예외 발생")
    void testInputPurchaseAmountWithInvalidInput() {
        provideInput("invalid\n");
        assertThrows(IllegalArgumentException.class, InputView::inputPurchaseAmount);
    }
}