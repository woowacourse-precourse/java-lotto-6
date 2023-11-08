package lotto.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @DisplayName("유효한 구입 금액을 입력하면 예외가 발생하지 않는다.")
    @Test
    public void testValidPurchaseAmountValid() {
        assertDoesNotThrow(() -> inputView.validatePurchaseAmount("8000"));
    }
}
