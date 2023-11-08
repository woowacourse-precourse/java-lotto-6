package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import lotto.controller.Controller;
import lotto.domain.Purchase;
import lotto.exception.LottoException;
import lotto.model.Model;
import lotto.model.parser.Parser;
import lotto.view.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ControllerTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Mock
    private Model model;
    @Mock
    private View view;
    private Controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(model, view);
    }

    @Test
    @DisplayName("유효한 구매 금액 입력을 받았을 때 Purchase 객체를 반환한다.")
    void promptPurchase_WhenValidInput_ReturnsPurchase() {
        try (MockedStatic<Parser> mockedParser = Mockito.mockStatic(Parser.class)) {
            String validPurchaseInput = "1000";
            when(view.readInput()).thenReturn(validPurchaseInput);
            mockedParser.when(() -> Parser.parseInputToPurchasePrice(validPurchaseInput)).thenReturn(1000);

            Purchase purchase = controller.promptPurchase();

            verify(view).readInput();
            assertEquals(1000, purchase.getPurchasePrice());
        }
    }

    @Test
    @DisplayName("유효한 당첨 번호 입력을 받았을 때 WinningNumbers 리스트를 반환한다.")
    void promptWinningNumbers_WhenValidInput_ReturnsWinningNumbers() {
        try (MockedStatic<Parser> mockedParser = Mockito.mockStatic(Parser.class)) {
            String validWinningNumbersInput = "1, 2, 3, 4, 5, 6";
            List<Integer> expectedWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            when(view.readInput()).thenReturn(validWinningNumbersInput);
            mockedParser.when(() -> Parser.parseInputToWinningNumbers(validWinningNumbersInput)).thenReturn(expectedWinningNumbers);

            List<Integer> winningNumbers = controller.promptWinningNumbers();

            verify(view).readInput();
            assertEquals(expectedWinningNumbers, winningNumbers);
        }
    }

    @Test
    @DisplayName("유효한 보너스 번호 입력을 받았을 때 보너스 번호를 반환한다.")
    void promptBonusNumber_WhenValidInput_ReturnsBonusNumber() {
        try (MockedStatic<Parser> mockedParser = Mockito.mockStatic(Parser.class)) {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            String validBonusNumberInput = "7";
            int expectedBonusNumber = 7;
            when(view.readInput()).thenReturn(validBonusNumberInput);
            mockedParser.when(() -> Parser.parseInputToBonusNumber(eq(winningNumbers), eq(validBonusNumberInput))).thenReturn(expectedBonusNumber);

            int bonusNumber = controller.promptBonusNumber(winningNumbers);

            verify(view).readInput();
            assertEquals(expectedBonusNumber, bonusNumber);
        }
    }

    @Test
    @DisplayName("잘못된 구매 금액 입력을 받았을 때 사용자에게 다시 요청한다.")
    void promptPurchase_WhenInvalidInput_RequestsInputAgain() {
        try (MockedStatic<Parser> mockedParser = Mockito.mockStatic(Parser.class)) {
            mockedParser.when(() -> Parser.parseInputToPurchasePrice(anyString()))
                    .thenThrow(LottoException.from(ERROR_MESSAGE))
                    .thenThrow(LottoException.from(ERROR_MESSAGE))
                    .thenReturn(1000);

            when(view.readInput())
                    .thenReturn("")
                    .thenReturn("invalid input")
                    .thenReturn("1000");

            Purchase purchase = controller.promptPurchase();

            verify(view, times(3)).readInput();
            verify(view, times(2)).displayErrorMessage(any(LottoException.class));
            assertEquals(1000, purchase.getPurchasePrice());
        }
    }

    @Test
    @DisplayName("잘못된 당첨 번호 입력을 받았을 때 사용자에게 다시 요청한다.")
    void promptWinningNumbers_WhenInvalidInput_RequestsInputAgain() {
        try (MockedStatic<Parser> mockedParser = Mockito.mockStatic(Parser.class)) {
            mockedParser.when(() -> Parser.parseInputToWinningNumbers(anyString()))
                    .thenThrow(LottoException.from(ERROR_MESSAGE))
                    .thenThrow(LottoException.from(ERROR_MESSAGE))
                    .thenThrow(LottoException.from(ERROR_MESSAGE))
                    .thenReturn(Arrays.asList(1, 2, 3, 4, 5, 6));

            when(view.readInput())
                    .thenReturn("1, 2, 3, 4, 5")
                    .thenReturn("1, 1, 1, 1, 1, 1")
                    .thenReturn("1, 2, 3, 4, 5, 46")
                    .thenReturn("1, 2, 3, 4, 5, 6");

            List<Integer> winningNumbers = controller.promptWinningNumbers();

            verify(view, times(4)).readInput();
            verify(view, times(3)).displayErrorMessage(any(LottoException.class));
            assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winningNumbers);
        }
    }

    @Test
    @DisplayName("잘못된 보너스 번호 입력을 받았을 때 사용자에게 다시 요청한다.")
    void promptBonusNumber_WhenInvalidInput_RequestsInputAgain() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        try (MockedStatic<Parser> mockedParser = Mockito.mockStatic(Parser.class)) {
            mockedParser.when(() -> Parser.parseInputToBonusNumber(eq(winningNumbers), anyString()))
                    .thenThrow(LottoException.from(ERROR_MESSAGE))
                    .thenThrow(LottoException.from(ERROR_MESSAGE))
                    .thenReturn(7);

            when(view.readInput())
                    .thenReturn("0")
                    .thenReturn("1")
                    .thenReturn("7");

            int bonusNumber = controller.promptBonusNumber(winningNumbers);

            verify(view, times(3)).readInput();
            verify(view, times(2)).displayErrorMessage(any(LottoException.class));
            assertEquals(7, bonusNumber);
        }
    }
}
