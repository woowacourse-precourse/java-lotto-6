package lotto.Test.ExceptionTest;

import lotto.controller.inputController.LottoPurchaseController;
import lotto.model.lottoGenerator.LottoPurchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseTest {

    private LottoPurchase lottoPurchase;
    private LottoPurchaseController mockPurchaseController;

    @BeforeEach
    void setUp() {
        mockPurchaseController = Mockito.mock(LottoPurchaseController.class);
        lottoPurchase = new LottoPurchase(mockPurchaseController);
    }

    @Test
    @DisplayName("입력값이 비어있을 경우 예외를 발생시켜야 한다")
    void  EmptyTest() {
        Mockito.when(mockPurchaseController.requestPurchaseAmount()).thenReturn("");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> lottoPurchase.getValidatedPurchaseAmount());
        assertEquals("[ERROR] 입력값이 비어있습니다. 다시 입력해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 예외를 발생시켜야 한다")
    void NotNumberTest() {
        Mockito.when(mockPurchaseController.requestPurchaseAmount()).thenReturn("abc");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> lottoPurchase.getValidatedPurchaseAmount());
        assertEquals("[ERROR] 숫자만 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값이 음수일 경우 예외를 발생시켜야 한다.")
    void PositiveNumberTest() {
        Mockito.when(mockPurchaseController.requestPurchaseAmount()).thenReturn("-1000");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> lottoPurchase.getValidatedPurchaseAmount());
        assertEquals("[ERROR] 구매 금액은 0원보다 커야 합니다. 다시 입력해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값이 1000원단위가 아닌 경우 예외를 발생시켜야 한다.")
    void UnitTest() {
        Mockito.when(mockPurchaseController.requestPurchaseAmount()).thenReturn("2500");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> lottoPurchase.getValidatedPurchaseAmount());
        assertEquals("[ERROR] 로또 구매 금액은 1000원 단위로 입력해야 합니다. 다시 입력해주세요.", exception.getMessage());
    }
}
