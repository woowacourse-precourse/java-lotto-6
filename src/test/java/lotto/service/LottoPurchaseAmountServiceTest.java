package lotto.service;

import static lotto.exception.ExceptionConstant.ERROR_PREFIX;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT_MESSAGE;
import static lotto.io.message.InputMessage.READ_PURCHASE_AMOUNT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.io.read.InputReader;
import lotto.service.validation.LottoValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class LottoPurchaseAmountServiceTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    LottoPurchaseAmountService lottoPurchaseAmountService;

    @Mock
    InputReader mockReader;

    @Spy
    LottoValidator spyValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoPurchaseAmountService = new LottoPurchaseAmountService(mockReader, spyValidator);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 사용자가_유효한_로또_구매_금액을_입력하면_반환한다() {
        //Arrange
        String userInput = "3000";
        int expected = 3000;

        when(mockReader.readLine()).thenReturn(userInput);
        doNothing()
                .when(spyValidator)
                .verifyPurchaseAmount(userInput);

        //Act
        int actual = lottoPurchaseAmountService.readLottoPurchaseAmount();

        //Assert
        assertThat(outputStreamCaptor.toString())
                .contains(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());

        assertThat(actual).isEqualTo(expected);
    }

    @CsvSource(value = {"0", "-1", "999", "' ", "abcd"})
    @ParameterizedTest
    void 사용자가_유효하지_않은_로또_구매_금액을_입력하면_예외_메시지를_출력하고_재입력_받는다(String invalidInput) {
        //Arrange
        String validInput = "2000";
        int expected = 2000;

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        doThrow(new IllegalArgumentException("Invalid amount"))
                .when(spyValidator)
                .verifyPurchaseAmount(invalidInput);

        doNothing()
                .when(spyValidator)
                .verifyPurchaseAmount(validInput);

        //Act
        int actual = lottoPurchaseAmountService.readLottoPurchaseAmount();

        //Assert
        assertThat(outputStreamCaptor.toString())
                .contains(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());

        assertThat(expected).isEqualTo(actual);

        verify(mockReader, times(2)).readLine();
        verify(spyValidator).verifyPurchaseAmount(invalidInput);
        verify(spyValidator).verifyPurchaseAmount(validInput);
    }

    @CsvSource(value = {"0", "-1", "999", "' ", "abcd"})
    @ParameterizedTest
    void 사용자가_유효하지_않은_로또_구매_금액을_입력하면_예외_메시지를_출력한다(String invalidInput) {
        //Arrange
        String validInput = "2000";

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        //Act
        lottoPurchaseAmountService.readLottoPurchaseAmount();

        //Assert
        assertThat(outputStreamCaptor.toString())
                .contains(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());

        assertThat(outputStreamCaptor.toString()).contains(
                String.format("%s %s", ERROR_PREFIX, INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage()));
    }
}